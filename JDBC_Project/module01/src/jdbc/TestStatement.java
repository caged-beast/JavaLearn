package jdbc;
//Statement API

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestStatement {
    @Test
    public void testDML() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "update student set class=8 where name=\"chw\"";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        int cnt = stmt.executeUpdate(sql);//返回受影响的行数
        //6.处理结果
//        System.out.println("更新了"+cnt+"条数据");
        System.out.println(cnt>0?"修改成功":"修改失败");
        //7.释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "create database db2";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        int cnt = stmt.executeUpdate(sql);//DDL执行成功可能也返回0
        //6.处理结果
//        System.out.println("更新了"+cnt+"条数据");
//        System.out.println(cnt>0?"修改成功":"修改失败");
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
