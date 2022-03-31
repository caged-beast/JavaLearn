# Java学习

## 1.环境

### JDK的下载安装

+ JVM：JAVA Virtual Machine(JAVA虚拟机)，真正运行Java程序的地方，JVM保证了Java程序的跨平台
+ JRE：JAVA Runtime Environment（JAVA运行环境），JRE包含JVM和Java的核心类库
+ JDK：JAVA Development Kit(JAVA开发工具包)，JDK包含JRE和Java的开发工具

要运行一个Java程序，只需安装JRE。要开发一个Java程序，需要安装JDK。

1. 下载：进入[Oracle官网]:(https://www.oracle.com/)，点击Products->选择Java->点击Download Java->往下滑，找到相应的版本下载即可（这里选Java 11）
2. 安装：点击下载好的exe文件进行安装，如果要修改安装位置的话建议根据默认的路径新建文件夹来存放。比如如果默认安装在C:\Program Files\Java\jdk-11.0.13路径的话，但是我们想要安在D盘，就可以在D盘新建相应的文件夹，如D:\Java\jdk-11.0.13，然后选择它作为安装位置即可（注意路径最好不带中文或空格）
3. 配置环境变量：系统变量->新建->变量名输入JAVA_HOME，变量值输入刚刚的安装目录，这里是D:\Java\jdk-11.0.13->保存退出。然后：在系统变量中选中Path环境变量->编辑->新建->输入%JAVA_HOME%\bin（建议输入完选中该项，上移至首位）->保存退出。
4. 在命令行输入javac验证上述步骤是否成功（如果命令行窗口在配置环境变量之前打开的要重启命令行窗口）

### 文本编辑器的下载安装

1. 这里可以下载Notepad++作为代码编辑器
2. 打开Notepad++->设置->首选项->新建->默认语言选择Java，编码选择ANSI->保存退出

#### 程序的编译运行

1. 编辑：编写好程序，保存为XXX.java[^1]
2. 编译：输入命令：javac后接文件名XXX.java，生成XXX.class文件
3. 执行：输入命令：java后接类名XXX[^2]

### IDEA

#### 1.IDEA的下载安装

IDEA（全称IntelliJ IDEA），是Java的IDE

1. 下载：进入[JetBrains官网]:(https://www.jetbrains.com/)->点击Developer Tools->选择IntelliJ IDEA->点击Download->选择对应的社区版本下载即可
2. 安装：点击下载好的exe文件进行安装，中间勾选上创建快捷方式

#### 2.流程

Eclipse中有工作空间workspace和项目project的概念，可以在一个工作空间里创建多个项目，共享设置。而IDEA没有工作空间的概念，只有项目和模块module的概念。使用IDEA，可以先创建一个空项目，然后在该空项目里创建多个模块，这就实现了类似的功能。

1. 新建空项目：New Project->选择Empty Project->输入项目名称（如Project01）和保存路径（推荐先创建一个专门存放Java项目的文件夹，如D:\Java_Projects，那么这里的保存路径就是D:\Java_Projects\Project01[^3]，会提示帮你创建Project01文件夹）
2. 新建模块：点击File->Project Structure->选择Modules->点击加号-> New Module->选择Java->（会自动识别JDK版本）点击Next->输入模块名（如Module01）->点击Finish->OK
3. 新建包：在刚刚创建的模块下选中src文件夹，右击->New->Package->输入包名
4. 新建类：选中刚刚创建的包，右击->New->Java Class->输入类名
5. 编写程序：在刚刚创建的类中编写代码
6. 执行程序: 在编辑区右击->Run（要执行的class文件在模块同级目录的out文件夹下）

#### 3.快捷键

1. 快速生成main()方法：psvm+回车
2. 快速生成输出语句：sout+回车
3. 复制一行：Ctrl+D
4. 删除一行（其实是剪切）：Ctrl+X
5. 格式化代码：Ctrl+Alt+L
6. 上下移动代码：Shift+Alt+上下箭头
7. 注释：Ctrl+/（行注释），Ctrl+Shift+/（块注释）
8. 要输出某对象，直接在对象后接.sout
9. 快速生成toString()代码：tos+回车
10. 快速生成equals()代码：equ+回车
11. 快速生成for循环：fori+回车
12. 查看源码：Ctrl+鼠标左键
13. 根据值快速生成变量：Ctrl+Alt+V
14. 快速生成try/catch：Ctrl+Alt+T
15. 整列编辑：Alt+鼠标左键

#### 4.设置

设置字体：File->Settings->Editor->Font

#### 5.导入模块

新建Module，然后把要导入的包直接粘贴（选中该Module，再Ctrl+V）

#### 6.Logback

1. 在maven中心仓库下载相关jar包，包括logback-classic、logback-core、slf4j-api
2. 在项目下新建一个directory，取名lib（习惯），把相关jar包粘贴到该文件夹下
3. 添加到依赖库：选中这些jar包->右键->add as library
4. 将Logback的核心配置文件logback.xml直接拷贝到src目录下，下面给出一个配置文件供参考
5. 在代码中获取日志对象: `public static final Logger LOGGER = LoggerFactory.getLogger("类对象");`
6. 使用日志对象输入日志信息

#### 7.杂谈

1. 建议一个代码文件定义一个类，即多个类分多个Class文件编写
2. 包名不能是Java关键字
3. JavaBean是一个实体类，标准JavaBean需要满足以下要求：
   1. 成员对象私有
   2. 提供对成员对象的get、set方法
   3. 提供无参构造器
4. 权限修饰符：public > protected > 缺省 > private
   1. private修饰的只能在本类中被访问
   2. 缺省的可以在本类中、同一个包的类中被访问
   3. protected修饰的可以在本类中、同一个包的类中、其他包的子类中被访问
   4. public修饰的可以在任何地方访问
5. 用public static final 修饰的是常量，常量命名通常全部大写，用下划线隔开
6. 在Project Structure 中可以切换模块的编译版本
7. 一个类如果既继承了父类，又实现了接口，如果父类和接口中有同名方法，优先调用父类中的
8. 关于接口，JDK 8之前接口只能包括常量和抽象方法，JDK 8 开始新增了默认方法和静态方法，JDK 9 开始新增了私有方法
   1. 默认方法(default)，由接口的实现类调用
   2. 静态方法(static)，由接口名调用，不能由接口的实现类调用是因为实现类可能会实现多个接口，多个接口可能会有同名方法，进而导致调用歧义
   3. 私有方法(private)，由接口内部调用
9. 多态中成员的访问特点
    1. 方法调用：编译看左边，执行看右边
    2. 变量调用：编译看左边，执行也看左边（多态侧重行为多态）
10. 比较对象内容是否相等时建议使用objects的equals方法，更加安全
11. Lambda可用于简化匿名内部类的代码，注意只能简化函数式接口(只有一个抽象方法的接口)的匿名内部类代码。格式是：被重写方法的形参列表->{方法体}。此外，Lambda表达式还可以进一步简化，有如下规则：
    1. 参数类型可以省略。如果只有一个参数，形参列表的()也可以省略
    2. 如果方法体代码只有一行，可以省略大括号和分号。如果这行代码是return语句，return可以省略
12. Collection集合体系中的常用实现类（Collection是单列集合接口）
    1. List接口（有序、可重复、有索引）
        1. ArrayList（有序、可重复、有索引）（底层基于数组实现）
        2. Linkedlist（有序、可重复、有索引）（底层基于双链表实现）
    2. Set接口（无序、不重复、无索引）（无序是指存进数据的顺序和取出数据的顺序可能不一致，无索引是指不支持索引操作）
       1. HashSet（无序、不重复、无索引）（无序、不重复、无索引），JDK8之前是数组+链表，JDK8之后是数组+链表+红黑树）
          1. LinkedHashSet（有序、不重复、无索引）（底层基于哈希表实现，但多用了一个双链表来链接所有元素，所以元素有序）
       2. TreeSet（默认升序、不重复、无索引）（底层基于红黑树实现）
13. Collection实现类的通用遍历方式有：迭代器、增强for循环、Lambda表达式
14. 比较器中，如果返回值大于0则交换位置，小于0则不变。所以要升序就用o1-o2，要降序就o2-o1
15. 实现对象的自定义比较有两种方式：
    1. 对象类实现Comparable接口并重写compareTo方法
    2. 使用Comparator比较器对象
16. 可变参数格式为“数据类型... 参数名”，可以接受任意个参数，也可以接受数组。其实在方法内部它实质上就是一个数组
17. Map集合体系中的常用实现类（Map是单列集合（也叫键值对集合）接口）（键无序、不重复、无索引）
    1. HashMap（键无序、不重复、无索引）（底层基于哈希表实现，其实Set系列集合的底层就是由Map实现的，只是Set只要键，不要值）
        1. LinkedHashMap（键有序、不重复、无索引）
    2. HashTable
       1. Properties（比较特殊，常结合IO流用来把键值对信息存入Properties属性文件）
    3. 某接口
       1. TreeMap（键默认升序、不重复、无索引）

18. List、Set、Map的of()静态方法创建的都是不可变集合
19. java文件通过javac.exe编译成字节码文件（class文件），再通过java.exe运行。在前一个阶段要处理的异常叫做编译时异常，在后一个阶段要处理的异常叫运行时异常
20. Exception类下有RuntimeException子类和其它子类，运行时异常继承RuntimeException或其子类，编译时异常继承Exception或其（未继承RuntimeException的）子类
21. 正斜杠/斜率为正，反斜杠\斜率为负
22. 自定义异常：
    1. 定义一个异常类继承Exception或RuntimeException
    2. 重写构造器
    3. 在出现异常的地方用throw new抛出自定义异常对象

23. 日志规范（接口）有JCL(Commons Logging)和slf4j(Simple Logging Facade for Java)，Logback是实现了slf4j的日志框架
24. 做一个小项目时，可以新建一个模块来单独存放，新建一个bean包来存放所有的对象类，新建一个run包来存放程序运行代码
25. listFile()方法可以返回某目录下的一级文件或目录的File对象的数组，如果输入的目录不存在或输入的目录没有打开权限或输入的是一个文件则返回null，如果输入的目录为空则返回长度为0的数组
26. 字符集的发展:
    1. ASCII字符集用一个字节存储一个字符，对于英文、数字是够用的
    2. ASCII对汉字来说不够用，所以我国有了自己的码表GBK（属于ANSI），用两个字符来存储一个汉字，并兼容ASCII
    3. 各国使用自己的字符集不利于统一，所以有了Unicode（UTF-8是Unicode中的一种编码方案），UTF-8编码后一般用三个字符来存储一个汉字，同样兼容ASCII

27. String提供了字符串的编、解码API
28. IO流体系
    1. 字节流
       1. InputStream（抽象类）（字节输入流）
          1. FileInputStream
             1. BufferedInputStream（缓冲流自带缓冲区（8KB））
          2. ObjectInputStream
       2. OutputStream（抽象类）（字节输出流）
          1. FileOutputStream
             1. BufferedOutputStream
          2. ObjectOutputStream
          3. PrintStream
    2. 字符流
       1. Reader（抽象类）（字符输入流）
          1. FileReader（其实是Reader的孙子）
          2. BufferedReader
          3. InputStreamReader（字符输入转换流）
       2. Writer（抽象类）（字符输出流）
          1. FileWriter（其实是Writer的孙子）
          2. BufferedWriter
          3. OutputStreamWriter（字符输出转换流）
          4. PrintWriter

29. 如果代码编码和要读写的文件的编码不一致，会导致乱码问题。为了解决可以使用字符输入转换流。具体来说，可以先用FileInputStream提取（GBK）文件的原始字节流，然后用InputStreamReader把原始字节流以指定编码转换成字符输入流。类似的，可以用字符输出转换流OutputStreamWriter包装FileOutputStream来以指定编码格式输出
30. 对象序列化是指把对象数据存入到磁盘中，可以使用对象字节输出流ObjectOutputStream来做到，要序列化的对象必须要实现Serializable接口
31. commons-io是apache提供的一组有关IO操作的类库，主要有FileUtils、IOUtils。相关jar包的下载：直接搜索commons-io，在apache官网下载类似commons-io-2.11.0-bin.zip的文件，解压后commons-io-2.11.0.jar即为核心jar包
32. 如果要用到别人的jar包，在项目下新建一个directory，取名lib（习惯），把相关jar包粘贴到该文件夹下。再添加到依赖库：选中这些jar包->右键->add as library。然后就可以导包使用了
33. 创建多线程有三种方法：
    1. 创建类继承Thread->重写run()->创建线程对象
    2. 创建类实现Runnable接口->重写run()->创建Runnable任务对象->创建线程对象
    3. 创建类实现Callable接口->重写call()->创建Callable任务对象->创建FutureTask对象->创建线程对象
34. 使用多线程访问共享资源时可以会出现并发修改异常，加锁的方式有三种：
    1. 同步代码块。把出现问题的代码块放入synchronized(锁对象){}的方法体中，建议把共享资源当做锁对象，如对于实例方法建议把this作为锁对象，对于静态方法建议把类名.class对象作为锁对象
    2. 同步方法。用synchronized修饰出现问题的方法
    3. Lock锁。实例化一个实现了Lock接口的对象（如ReentrantLock），调用其加、解锁方法
35. 如果每个请求都创建一个线程，会消耗大量的系统资源，为了解决这个问题产生了复用线程的技术：线程池。常用的创建线程池方法是创建ThreadPoolExecutor对象，ThreadPoolExecutor类实现了线程池接口ExecutorService，重点理解参数`ThreadPoolExecutor​(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)`
36. 什么时候会创建临时线程：线程池中的核心线程占满，而且工作队列也满了，再来新的任务会创建临时线程
37. 什么时候执行策略：线程池中的线程数达到设定的最大值，而且工作队列也满了，再来新的任务会执行预定策略
38. 也可以用Executors工具类来创建线程池，但是这种创建不适合大型并发系统，因为它往往不限制线程数量或者工作队列长度，可能会导致系统资源耗尽
39. Executors工具类提供的newScheduledThreadPool()静态方法基于线程池实现了定时器的功能
40. 进行网络编程时可能需要多发启动某段程序，可以点击右上角锤子右边的选项卡下拉键->Modify options->勾选Allow multiple instances->Apply->OK保存退出
41. 单元测试是对最小的功能单元编写测试代码，JUnit是单元测试框架。单元测试函数必须公开、无参数（即public void修饰），且用@Test注解
42. 在运行时动态获取类信息以及动态调用类中成分的能力称为Java的反射机制
43. 关于文件的相对路径，在Junit Test方法中创建的文件和src目录同级，而在main()方法中创建的文件目录却和Module目录同级
44. 要使用反射，第一步就要获取Class类对象，有三种方法:
    1. Class的静态方法：Class.forName(包名+类名)
    2. 类名.class
    3. 对象.getClass()
45. 反射技术的作用：
    1. 使用反射技术获取构造器对象，如getDeclaredConstructors()，然后可以使用Constructor对象的newInstance()方法创建对象
    2. 使用反射技术获取成员变量，如getDeclaredFields()，然后可以使用Field对象的set()和get()的方法为对象的成员变量赋值或取值
    3. 使用反射技术获取成员方法，如getDeclaredMethods()，然后可以使用Method对象的invoke()方法对某个对象执行此方法
46. XML(Extensible Markup Language)可扩展标记语言，是一种数据的表示格式。XML内容常被用于网络传输或作为配置文件
47. Dom4j是DOM解析的常用框架，在其官网可以直接找到其jar包

[^1]: 注意要先在“查看”选项卡里面把文件的扩展名打开
[^2]: JDK11开始支持java直接运行源代码文件（即java命令后直接跟XXX.java文件）
[^3]: 这里的空项目的保存路径一定要在存放所有项目的文件夹（如这里的D:\Java_Projects）后接具体的项目名称，否则之后添加模块会有问题