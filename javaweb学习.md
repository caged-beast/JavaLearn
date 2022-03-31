# JavaWeb

## 1.MySQL

### 1.1 卸载

1. 右击计算机->管理->服务和应用程序->服务->找到MySQL->右键停止
2. 在控制面板中卸载MySQL相关程序

### 1.2 下载安装

1. 进入MySQL官网，找到MySQL Community (GPL) Downloads->选择MySQL Community Server->进入Archives选择历史版本（根据需求选择即可）->选择Windows (x86, 64-bit), ZIP Archive下载
2. 对下载完的ZIP文件进行解压[^1]
3. 把bin目录加入path环境变量
4. 以管理员身份运行命令行，输入`mysqld --initialize-insecure`初始化mysql->输入`mysqld -install`注册mysql服务->输入`net start mysql`启动mysql服务->输入`mysqladmin -u root password 1234`修改默认账户密码
5. mysql.exe是一个客户端，输入`mysql -uroot -p1234`登录（登录mysql参数`mysql -u用户名 -p密码 -h要连接的mysql服务器的ip地址(默认127.0.0.1) -P端口号(默认3306)`）

### 1.3 Navicat图形化界面

在Navicat官网下载安装，从左上角Connection连接mysql服务器

注意事项：

1. varchar类型想要填入中文需要设置字符集为UTF-8

## 2.JDBC

### 2.1 介绍

1. JDBC(Java DataBase Connectivity)是用java语言操作关系型数据库的一套API
2. Sun公司定义了一套接口，各个数据库厂商依照这套接口提供驱动jar包（实现类）
3. 用JDBC编程，底层数据库变换时，只需要更换驱动jar包，不用更改java代码

### 2.2 使用

#### 1.mysql驱动jar包

进入MySQL官网，找到MySQL Community (GPL) Downloads->选择Connector/J->进入Archives选择历史版本（根据需求选择即可）->选择Platform Independent (Architecture Independent), ZIP Archive下载->把mysql-connector-java-5.1.49-bin.jar导入项目即可

#### 2.3 JDBC常用API

1. DriverManager：注册驱动`registerDriver​(Driver driver)`、获取数据库连接`getConnection​(String url, String user, String password)`，参数url是 jdbc:mysql://ip地址(或域名):端口号/要连接的数据库?参数键值对
2. Connection：获取执行SQL的对象`createStatement()`和`prepareStatement​(String sql)`、管理事`setAutoCommit​(boolean autoCommit)`开启事务，`commit()`提交事务，`rollback()`回滚事务
3. Statement：执行SQL操作`executeUpdate​(String sql)`执行DML、DDL，`executeQuery​(String sql)`执行DQL
4. ResultSet：封装了DQL查询的结果`next()`返回下一行数据是否有效，`getXxx()`返回某列的结果，可以接收第几列或字段名
5. PreparedStatement：预编译[^2]SQL语句并执行（要在getConnection的url中添加键值对useServerPrepStmts=true来开启预编译功能），防止SQL注入问题（SQL注入是指通过操作输入来修改事先定义好的SQL语句，用以达到执行代码对服务器进行攻击的方法）（通过将敏感字符进行转义）

#### 2.4 JDBC框架

```java
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "update student set class=8 where name='chw'";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        int cnt = stmt.executeUpdate(sql);
        //6.处理结果
        System.out.println("更新了"+cnt+"条数据");
        //7.释放资源
        stmt.close();
        conn.close();
```

#### 2.5 数据库连接池

1. Sun提供了数据库连接池标准接口DataSource，由第三方组织实现此接口。Druid连接池是阿里的项目。
2. 在[下载地址](https://repo1.maven.org/maven2/com/alibaba/druid/) 下载相关jar包，如druid-1.2.0.jar
3. Druid配置文件参考：

```XML
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true&characterEncoding=utf-8
username=root
password=123456
#初始化连接数量
initialSize=5
#最大连接数
maxActive=10
#最大等待时间
maxWait=3000
```

4. 框架

```java
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream("module01/src/druid.properties")));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
```

## 3. Maven

### 3.1 介绍

Maven是专门用于管理和构建java项目的工具，主要功能如下：

1. Maven提供了一套标准化的项目结构：不同的IDE的项目结构可能不同，影响了项目的通用性，而所有IDE使用Maven构建的项目结构完全一致
2. Maven提供了一套标准化的构建流程：编译、测试、打包、发布等
3. Maven提供了一套依赖管理机制：Maven使用标准的坐标配置来管理各种依赖

### 3.2 仓库

导入依赖->先到本地仓库找->本地仓库没有，再去远程仓库找->远程仓库没有，再去中央仓库找->找到传回远程仓库，并且远程仓库会下载保存相关jar包等文件->接着传回本地仓库，并且计算机会下载保存相关jar包等文件到本地

1. 本地仓库：自己计算机上的一个目录
2. 中央仓库：由Maven团队维护的全球唯一仓库
3. 远程仓库（私服）：一般由公司团队搭建的私有仓库

### 3.3 下载安装配置

1. 进入Maven官网->Download->下滑找到Archives->选择合适的版本->选择binaries/ [^3]->选择压缩文件如apache-maven-3.5.4-bin.zip进行下载->解压
2. 将bin目录添加到path环境变量
3. 修改conf/settings.xml配置文件中的本地仓库位置（默认在当前系统用户的.m2文件夹下），如在Maven目录下创建mvn_repo文件夹当做本地仓库，并添加配置信息`<localRepository>D:\apache-maven-3.5.4\mvn_repo</localRepository>`
4. 配置阿里云私服：修改conf/settings.xml配置文件中\<mirrors>标签，为其添加如下子标签：

```XML
<mirror>
    <id>alimaven</id>
    <mirrorOf>central</mirrorOf>
    <name>aliyun maven</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

### 3.4 Maven使用

#### 1.IDE中使用Maven

1. 配置：在设置中搜索Maven->修改Maven目录Maven home path和配置文件User settings file->apply->ok
2. 创建Maven工程：新建module时选择Maven，可以在Artifact coordinates设置坐标
3. 如果运行程序报错“不支持发行版本5”：在设置中找到java compiler，把Target bytecode version改成一致的版本->把以下jdk设置加入pom.xml配置文件（我这里是jdk11）

```XML
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

4. 导入Maven项目：点击IDEA右侧Maven选项卡->点击加号->找到要导入的Maven项目的pom.xml，双击
5. 在设置中找到Plugins，安装Maven Helper插件

#### 2.常用命令

1. 编译：mvn compile。生成target目录，其中包含编译后的class文件
2. 清理：mvn clean。删除target目录
3. 测试：mvn test。对test目录下的代码进行测试
4. 打包：mvn package。对当前项目进行打包，放在target文件中
5. 安装：mvn install。将当前项目安装到本地仓库

#### 3.生命周期

Maven构建项目生命周期描述的是一次构建过程中经历了多少事件。Maven生命周期分为三套：

1. clean：清理工作，包括pre-clean->clean->post-clean
2. default：核心工作，包括compile->test->package->install
3. site：产生报告，发布站点，包括pre-site->site->post-site

#### 4.依赖管理

1. 坐标：在[Maven 中央仓库](https://mvnrepository.com/) 搜索自己需要的jar包->把坐标导入pom.xml，并刷新依赖（右击pom.xml->Maven->reload project，或者使用Maven Helper插件的刷新功能）。其实对于曾经下载过的依赖，可以Alt+Insert添加其坐标。
2. 依赖范围：通过设置坐标的依赖范围（scope），可以设置对应jar包的作用范围

## 4.MyBatis

### 4.1 介绍

1. Mybatis是一款优秀的持久层框架，用于简化JDBC开发。JavaEE有三层架构：表现层、业务层、持久层，持久层负责将数据保存到数据库的那一层代码
2. JDBC在注册驱动、获取连接、编写SQL语句时存在存在大量硬编码，MyBatis通过编写配置文件来解决。JDBC需要手动设置参数、手动封装结果集，操作繁琐，MyBatis简化了相关操作

### 4.2 使用

#### 1.准备

在使用MyBatis框架前要进行一些准备工作，特别是不同配置文件之间的交叉

1. 要使用Logback时，除了需要导入相关坐标（logback-classic、logback-core、slf4j-api，注意依赖范围scope不要设置成test，否则编译会warn），还要添加核心配置文件logback.xml到src/main/resources下，下面给出一个参考：

```XML
<!-- 级别从高到低 OFF 、 FATAL 、 ERROR 、 WARN 、 INFO 、 DEBUG 、 TRACE 、 ALL -->
<!-- 日志输出规则 根据当前ROOT 级别，日志输出时，级别高于root默认的级别时 会输出 -->
<!-- 以下 每个配置的 filter 是过滤掉输出文件里面，会出现高级别文件，依然出现低级别的日志信息，通过filter 过滤只记录本级别的日志 -->
<!-- scan 当此属性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true。 -->
<!-- scanPeriod 设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，默认单位是毫秒。当scan为true时，此属性生效。默认的时间间隔为1分钟。 -->
<!-- debug 当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false。 -->
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <!-- 动态日志级别 -->
    <jmxConfigurator />
    <!-- 定义日志文件 输出位置 -->
    <!-- <property name="log_dir" value="C:/test" />-->
    <property name="log_dir" value="D:/Java_Projects/MyBatis_Project" />
    <!-- 日志最大的历史 30天 -->
    <property name="maxHistory" value="30" />

    <!-- ConsoleAppender 控制台输出日志 -->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                <!-- 设置日志输出格式 -->
                %d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n
            </pattern>
        </encoder>
    </appender>

    <!-- ERROR级别日志 -->
    <!-- 滚动记录文件，先将日志记录到指定文件，当符合某个条件时，将日志记录到其他文件 RollingFileAppender -->
    <appender name="ERROR" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 过滤器，只记录WARN级别的日志 -->
        <!-- 果日志级别等于配置级别，过滤器会根据onMath 和 onMismatch接收或拒绝日志。 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <!-- 设置过滤级别 -->
            <level>ERROR</level>
            <!-- 用于配置符合过滤条件的操作 -->
            <onMatch>ACCEPT</onMatch>
            <!-- 用于配置不符合过滤条件的操作 -->
            <onMismatch>DENY</onMismatch>
        </filter>
        <!-- 最常用的滚动策略，它根据时间来制定滚动策略.既负责滚动也负责出发滚动 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--日志输出位置 可相对、和绝对路径 -->
            <fileNamePattern>
                ${log_dir}/error/%d{yyyy-MM-dd}/error-log.log
            </fileNamePattern>
            <!-- 可选节点，控制保留的归档文件的最大数量，超出数量就删除旧文件假设设置每个月滚动，且<maxHistory>是6， 则只保存最近6个月的文件，删除之前的旧文件。注意，删除旧文件是，那些为了归档而创建的目录也会被删除 -->
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>
                <!-- 设置日志输出格式 -->
                %d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n
            </pattern>
        </encoder>
    </appender>

    <!-- WARN级别日志 appender -->
    <appender name="WARN" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 过滤器，只记录WARN级别的日志 -->
        <!-- 果日志级别等于配置级别，过滤器会根据onMath 和 onMismatch接收或拒绝日志。 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <!-- 设置过滤级别 -->
            <level>WARN</level>
            <!-- 用于配置符合过滤条件的操作 -->
            <onMatch>ACCEPT</onMatch>
            <!-- 用于配置不符合过滤条件的操作 -->
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--日志输出位置 可相对、和绝对路径 -->
            <fileNamePattern>${log_dir}/warn/%d{yyyy-MM-dd}/warn-log.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- INFO级别日志 appender -->
    <appender name="INFO" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>INFO</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${log_dir}/info/%d{yyyy-MM-dd}/info-log.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- DEBUG级别日志 appender -->
    <appender name="DEBUG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>DEBUG</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${log_dir}/debug/%d{yyyy-MM-dd}/debug-log.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- TRACE级别日志 appender -->
    <appender name="TRACE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>TRACE</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${log_dir}/trace/%d{yyyy-MM-dd}/trace-log.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- root级别 DEBUG -->
    <root>
        <!-- 打印debug级别日志及以上级别日志 -->
        <level value="debug" />
        <!-- 控制台输出 -->
        <appender-ref ref="console" />
        <!-- 文件输出 -->
        <appender-ref ref="ERROR" />
        <appender-ref ref="INFO" />
        <appender-ref ref="WARN" />
        <appender-ref ref="DEBUG" />
        <appender-ref ref="TRACE" />
    </root>
</configuration>
```

2. 编写MyBatis核心配置文件：在src/main/resources下添加文件mybatis-config.xml，下面给出一个参考：

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///db1?useSSL=false&amp;characherEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <!--加载sql映射文件-->
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```

3. 编写SQL映射文件：在src/main/resources下添加文件UserMapper.xml（习惯上叫表明+Mapper.xml，这里我们要操作的表叫User），下面给出一个参考：

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace要唯一-->
<mapper namespace="test">
    <!-- id为sql操作的唯一标识，resultType为返回值的类型-->
    <select id="selectAll" resultType="pojo.User">
        select * from user;
    </select>
</mapper>
```

#### 2.一个入门案例

```java
public static void main(String[] args) throws IOException {
    //1.加载mybatis的核心配置文件，获取SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //2.获取SqlSession对象，用它来执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //3.执行sql
    List<User> users = sqlSession.selectList("test.selectAll");//参数为sql映射文件中的命名空间+sql操作唯一标识
    System.out.println(users);

    //4.释放资源
    sqlSession.close();
}
```

#### 3.配置数据库连接

IDEA没有和数据库建立连接，那么在sql映射文件中写sql语句时不能提供提示，配置数据库连接方法如下：

1. IDEA右侧Database->点击+号->Data Sources->MySQL->输入账号密码登录
2. 点击Test Connetion测试，如果通过就可以点击ok保存

#### 4.使用Mapper代理

1. 定义与sql映射文件同名的Mapper接口，并且将该接口与sql映射文件放在同一目录下（如Mapper接口相对路径为src/main/java/mapper/UserMapper.java，那么就在src/main/resources目录下创建一个文件夹mapper[^4]，并把sql映射文件UserMapper.xml拖到该文件夹下）
2. 设置sql映射文件的namespace属性为Mapper接口的全限定名，如这里是mapper.UserMapper。对应的mybatis核心配置文件中sql映射文件的路径也要设置为mapper/UserMapper.xml（这里要注意sql映射文件的namespace里用.而mybatis核心配置文件中的路径用/分隔）
3. 在Mapper接口中定义方法，方法名就是sql映射文件中sql语句的id，注意参数类型和返回值类型要对应（创建的对象的成员变量名必须和数据库中对象的字段名一致，大小写不敏感），否则读取数据可能会出错。更专业的做法是使用resultMap：数据库中的字段名常带有下划线，而在创建java对象时，类中成员变量命名一般用驼峰命名法。使用resultMap分为两步：定义\<resultMap>标签->在\<select>标签中使用resultMap属性替换resultType属性。下面是某sql映射文件中mapper标签内容在使用resultMap前后的变化：

```XML
<mapper namespace="mapper.BrandMapper">
    <select id="selectAll" resultType="pojo.Brand">
        select * from tb_brand;
    </select>
</mapper>
```

```XML
<!--使用resultMap-->
<mapper namespace="mapper.BrandMapper">
<!--    id是指当前映射的唯一标识，type是指对应的java类型，这里是mapper.BrandMapper的别名brand-->
    <resultMap id="brandResultMap" type="brand">
<!--        映射一般字段用result标签，映射主键用id字段-->
        <result column="brand_name" property="brandName" />
        <result column="company_name" property="companyName" />
    </resultMap>
<!--    原来的resultType="pojo.Brand"要换成resultMap="brandResultMap"-->
    <select id="selectAll" resultMap="brandResultMap">
        select * from tb_brand;
    </select>
</mapper>
```

4. 在遵守前三条规则的情况下，mybatis核心配置文件中加载sql映射文件的方式可以简化成包扫描的方式：原来每个映射文件都需要指明：

```XML
<mappers>
    <!--加载sql映射文件-->
    <mapper resource="mapper/UserMapper.xml"/>
    <mapper resource="mapper/StudentMapper.xml"/>
</mappers>
```

现在只需要扫描它们所在的包即可：

```XML
<mappers>
    <!--代理开发使用包扫描的方式加载sql映射文件-->
    <package name="mapper"/>
</mappers>
```

#### 5.安装MyBatisX插件

#### 6.配置文件mybatis-config.xml

1. environments标签可以配置多个数据库环境
2. typeAliases标签可以为java类型设置别名，如果在配置信息中加入以下代码

```XML
<typeAliases>
  <package name="pojo"/>
</typeAliases>
```

那么当使用在pojo包中的类时，我们就可以使用其别名（别名即不区分大小写的类名）（如在UserMapper.xml的sql映射文件中，原来的`resultType="pojo.User"`就可以改成`resultType="User"`或`resultType="user"`）

#### 7.注意事项

1. 在进行sql操作时如果涉及中文，需要在mybatis-config.xml中添加字符集的信息，如`<property name="url" value="jdbc:mysql:///db1?useSSL=false&amp;characterEncoding=UTF-8"/>`
2. 想要进行多条件的动态查询，可以用\<if>标签，用户输入哪几个查询条件就生成响应的sql语句片段，用\<where>标签替换sql查询中的where可以解决多条件的动态查询时sql语句的拼接语法错误问题。update和delete操作类似

[^1]: 对压缩文件进行解压前，先打开压缩文件看看，如果是有一个总文件夹的话就可以直接解压到当前文件夹，否则选择解压到某个目录下
[^2]: 预编译是指在获取PrepareStatement对象时就将sql语句发送给mysql服务器进行检查、编译，执行sql语句时就不用进行这些步骤了
[^3]: 关于文件后缀，bin代表二进制文件，src代表源码，源码source比binary大一些，一般正常使用下载bin类型即可，如果要学习源码下载src类型。tar.gz是linux的压缩包，zip是windows的压缩包
[^4]: 如果Mapper接口在src/main/java的多级目录下，注意在resources目录下创建多级目录不能用.而要用/
