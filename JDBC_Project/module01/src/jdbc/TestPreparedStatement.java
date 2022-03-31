package jdbc;
//PreparedStatement API

import org.junit.Test;

import java.sql.*;

public class TestPreparedStatement {
    //模拟登录
    @Test
    public void testLogin() throws Exception{
        //1.注册驱动，省略
//        Class.forName("com.mysql.jdbc.Driver");
        //2.连接mysql
        String url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.执行DQL
        //先读取输入
        String uname = "chw";
        String pwd = "123";
        Statement stmt = conn.createStatement();
        String sql = "select * from user where userName='"+uname+"' and password='"+pwd+"'";
        ResultSet rs = stmt.executeQuery(sql);
        //4.处理结果
        System.out.println(rs.next()?"登录成功":"登录失败");
        //5.关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

    //演示sql注入
    @Test
    public void testLogin_Inject() throws Exception{
        //1.注册驱动，省略
//        Class.forName("com.mysql.jdbc.Driver");
        //2.连接mysql
        String url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.执行DQL
        //先读取输入
        String uname = "dsadsa";
        String pwd = " 'or'1'='1 ";
        Statement stmt = conn.createStatement();
        String sql = "select * from user where userName='"+uname+"' and password='"+pwd+"'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        //4.处理结果
        System.out.println(rs.next()?"登录成功":"登录失败");
        //5.关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

    //用PreparedStatement解决sql注入
    @Test
    public void testLogin_pstmt() throws Exception{
        //1.注册驱动，省略
//        Class.forName("com.mysql.jdbc.Driver");
        //2.连接mysql
//        String url = "jdbc:mysql:///db1?useSSL=false";
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";//开启预编译
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.执行DQL
        //先读取输入
        String uname = "dsadsa";
        String pwd = " 'or'1'='1 ";
        Statement stmt = conn.createStatement();
//        String sql = "select * from user where userName='"+uname+"' and password='"+pwd+"'";
        //PreparedStatement要求的sql语句用?替代参数
        String sql = "select * from user where userName=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);//这里要参数
        pstmt.setString(1,uname);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();//这里不要参数

        //4.处理结果
        System.out.println(rs.next()?"登录成功":"登录失败");
        //5.关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
