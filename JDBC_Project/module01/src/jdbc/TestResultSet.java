package jdbc;
//ResultSet API

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TestResultSet {
    @Test
    public void testDQL() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "select * from student";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //6.处理结果
        while(rs.next()){//next()返回下一行数据是否有效
            int id = rs.getInt(1);//getXxx()返回某列的结果
            String name = rs.getString(2);
//            int c = rs.getInt(3);
            int c = rs.getInt("class");//getXxx()可以接收第几列或字段名
            System.out.println(id+"\t"+name+"\t"+c);
        }
        //7.释放资源
        rs.close();//ResultSet资源也要释放
        stmt.close();
        conn.close();
    }

    //将student表中的数据封装成Student对象，用ArrayListcunc
    @Test
    public void saveStudent() throws Exception{
        ArrayList<Student> list = new ArrayList<>();//存放学生对象

        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.定义sql
        String sql = "select * from student";
        //4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //6.处理结果
        while(rs.next()){//next()返回下一行数据是否有效
            int id = rs.getInt(1);//getXxx()返回某列的结果
            String name = rs.getString(2);
//            int c = rs.getInt(3);
            int c = rs.getInt("class");//getXxx()可以接收第几列或字段名
//            System.out.println(id+"\t"+name+"\t"+c);
            list.add(new Student(id,name,c));
        }
        //7.释放资源
        rs.close();//ResultSet资源也要释放
        stmt.close();
        conn.close();

        System.out.println(list);
    }
}
