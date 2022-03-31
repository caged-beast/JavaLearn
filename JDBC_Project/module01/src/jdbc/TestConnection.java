package jdbc;
//Connection API

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql1 = "update student set class=8 where name=\"chw\"";
        String sql2 = "update student set class=8 where name=\"zjq\"";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();


        try {
            conn.setAutoCommit(false);//关闭自动提交即开启事务
            //5.执行sql
            int cnt1 = stmt.executeUpdate(sql1);
            int cnt2 = stmt.executeUpdate(sql2);

            int i = 3/0;

            //6.处理结果
            System.out.println("更新了"+cnt1+"条数据");
            System.out.println("更新了"+cnt2+"条数据");
            conn.commit();//提交事务
        } catch (Exception e) {
            conn.rollback();//回滚事务
            e.printStackTrace();
        }


        //7.释放资源
        stmt.close();
        conn.close();

    }

}
