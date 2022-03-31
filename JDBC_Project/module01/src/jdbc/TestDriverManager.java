package jdbc;
//DriverManager API

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDriverManager {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //如果用的是mysql5之后的驱动，可以省略注册驱动的步骤，
        // 会自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类
//        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //参数url是jdbc:mysql://ip地址(或域名):端口号/要连接的数据库?参数键值对
        //如果连接的是本机的3306端口，可以简写成jdbc:mysql:///要连接的数据库
//        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "update student set class=8 where name=\"chw\"";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        int cnt = stmt.executeUpdate(sql);
        //6.处理结果
        System.out.println("更新了"+cnt+"条数据");
        //7.释放资源
        stmt.close();
        conn.close();

    }

}
