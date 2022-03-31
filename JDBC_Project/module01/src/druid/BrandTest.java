package druid;
//对tb_brand数据库进行操作

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class BrandTest {
    //1.查询所有数据
    @Test
    public void test1() throws  Exception{
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream("src/druid.properties")));
        //2.获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        //4.执行SQL语句
        String sql = "select * from tb_brand";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        //5.处理返回结果
        ArrayList<Brand> list = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            String brand_name = rs.getString(2);
            String company_name = rs.getString(3);
            int ordered = rs.getInt(4);
            String description = rs.getString(5);
            int status = rs.getInt(6);
            list.add(new Brand(id,brand_name,company_name,ordered,description,status));
        }
        System.out.println(list);
        //6.释放资源
        rs.close();
        pstmt.close();
        connection.close();
    }

    //2.添加数据
    @Test
    public void test2() throws  Exception{
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream("src/druid.properties")));
        //2.获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        //4.执行SQL语句
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status)" +
                " values(?,?,?,?,?)";//id自增
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //要添加中文，建立连接时url参数要设置字符集
        pstmt.setString(1,"香飘飘");
        pstmt.setString(2,"香飘飘有限公司");
        pstmt.setInt(3,10);
        pstmt.setString(4,"绕地球一圈");
        pstmt.setInt(5,1);
        int cnt = pstmt.executeUpdate();
        //5.处理返回结果
        System.out.println(cnt>0?"添加成功":"添加失败");
        //6.释放资源
        pstmt.close();
        connection.close();
    }

    //3.修改数据
    @Test
    public void test3() throws  Exception{
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream("src/druid.properties")));
        //2.获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        //4.执行SQL语句
        String sql = "update tb_brand set ordered=?,description=? where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //要添加中文，建立连接时url参数要设置字符集
        pstmt.setInt(1,1000);
        pstmt.setString(2,"绕地球三圈");
        pstmt.setInt(3,6);
        int cnt = pstmt.executeUpdate();
        //5.处理返回结果
        System.out.println(cnt>0?"修改成功":"修改失败");
        //6.释放资源
        pstmt.close();
        connection.close();
    }

    //3.删除数据
    @Test
    public void test4() throws  Exception{
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream("src/druid.properties")));
        //2.获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        //4.执行SQL语句
        String sql = "delete from tb_brand where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,6);
        int cnt = pstmt.executeUpdate();
        //5.处理返回结果
        System.out.println(cnt>0?"删除成功":"删除失败");
        //6.释放资源
        pstmt.close();
        connection.close();
    }
}
