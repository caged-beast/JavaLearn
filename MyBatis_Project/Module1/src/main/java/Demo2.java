import mapper.StudentMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo2 {
    //使用Mapper代理开发

    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
//        List<User> users = sqlSession.selectList("test.selectAll");//参数为sql映射文件中的命名空间+sql操作唯一表示
        //改为获取UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);

        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper1.selectAll();
        System.out.println(students);

        //4.释放资源
        sqlSession.close();

    }

}
