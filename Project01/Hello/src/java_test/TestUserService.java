package java_test;
//单元测试

import org.junit.*;

public class TestUserService {
    @Before//Before注解修饰实例方法，在每一个测试之前执行一次
    public void before(){
        System.out.println("=========before==========");
    }
    @After
    public void after(){
        System.out.println("=========after==========");
    }

    @BeforeClass//Before注解修饰静态方法，在所有测试之前执行一次
    public static void beforeC(){
        System.out.println("=========beforeC==========");
    }
    @AfterClass
    public static void afterC(){
        System.out.println("=========afterC==========");
    }

    @Test
    public void testLogin(){
        UserService us = new UserService();
        String ret = us.login("admin","123456");
        //进行预期结果的正确性测试：断言
        Assert.assertEquals("登录业务有问题","登录成功",ret);
    }

    @Test
    public void testSelectEmp(){
        UserService us = new UserService();
        us.selectEmp();
    }
}
