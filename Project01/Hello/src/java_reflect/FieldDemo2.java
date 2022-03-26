package java_reflect;
//使用反射技术获取成员变量后可以为对象的成员变量赋值或取值

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldDemo2 {
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Field field = Student.class.getDeclaredField("name");
        Student s = new Student();
        //暴力打开权限
        field.setAccessible(true);
        //赋值
        field.set(s,"Chandler");
        System.out.println(s);

        //取值
        String name = (String) field.get(s);
        System.out.println(name);
    }
}
