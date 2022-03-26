package java_reflect;
//使用反射技术获取构造器对象后可以使用构造器的newInstance()方法创建对象
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo2 {
    @Test
    public void testGetDeclaredConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //getConstructors()返回单个构造器(只含public)
        Constructor constructor = Student.class.getDeclaredConstructor();
        System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());

        //如果遇到私有构造器，可以暴力反射
        constructor.setAccessible(true);
        Student s1 = (Student) constructor.newInstance();
        System.out.println(s1);

        Constructor constructor1 = Student.class.getConstructor(String.class,int.class);
        Student s2 = (Student) constructor1.newInstance("Joey",21);
        System.out.println(s2);
    }
}
