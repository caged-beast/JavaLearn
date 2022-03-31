package jdbc;
//JDBC入门案例

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo1 {
    public static void main(String[] args) throws Exception {
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

    }

}
