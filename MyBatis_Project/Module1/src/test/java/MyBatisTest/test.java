package MyBatisTest;

import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Brand;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void testSelectAll() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int id = 2;
        Brand brand = mapper.selectById(id);
        System.out.println(brand);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 1;
        String companyName = "%"+"华为"+"%";//用到模糊查询
        String brandName = "%"+"华为"+"%";
        //1.散装参数
//        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        //2.对象参数
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        List<Brand> brands = mapper.selectByCondition(brand);
        //3.Map参数
        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
//        map.put("brandName",brandName);
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectBySingleCondition() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 1;
        String companyName = "%"+"华为"+"%";//用到模糊查询
        String brandName = "%"+"华为"+"%";

        Map map = new HashMap();
        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);
        List<Brand> brands = mapper.selectBySingleCondition(map);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        //mybatis默认开启事务，如果想要让sql修改生效，需要关闭事务，或打开自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 1;
        String companyName = "苹果公司";
        String brandName = "苹果";
        String description = "创造美";
        int ordered = 200;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        mapper.add(brand);

        System.out.println(brand.getId());

        //4.释放资源
        sqlSession.close();
    }


    @Test
    public void testUpdateAll() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        //mybatis默认开启事务，如果想要让sql修改生效，需要关闭事务，或打开自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 1;
        String companyName = "苹果科技有限公司";
        String brandName = "苹果";
        String description = "创造美好生活";
        int ordered = 2000;
        int id = 8;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);
        mapper.updateAll(brand);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateSingle() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        //mybatis默认开启事务，如果想要让sql修改生效，需要关闭事务，或打开自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 0;
        String companyName = "苹果科技有限公司";
        String brandName = "苹果";
        String description = "创造美好生活";
        int ordered = 2000;
        int id = 8;

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setOrdered(ordered);
//        brand.setDescription(description);
        brand.setId(id);
        mapper.updateSingle(brand);//只修改status值

        //4.释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        //mybatis默认开启事务，如果想要让sql修改生效，需要关闭事务，或打开自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int id = 5;
        mapper.deleteById(id);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行sql
        //mybatis默认开启事务，如果想要让sql修改生效，需要关闭事务，或打开自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int[] ids = {11,12,13};
        mapper.deleteByIds(ids);

        //4.释放资源
        sqlSession.close();
    }
}
