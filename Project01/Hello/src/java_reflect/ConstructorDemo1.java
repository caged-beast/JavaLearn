package java_reflect;
//使用反射技术获取构造器对象

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstructorDemo1 {
    @Test
    public void testGetConstructors(){
        //getConstructors()返回所有构造器的数组(只含public)
        Constructor[] constructors = Student.class.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());
        }
    }

    @Test
    public void testGetDeclaredConstructors() throws NoSuchMethodException {
        //getDeclaredConstructors()返回所有构造器的数组
        Constructor[] constructors = Student.class.getDeclaredConstructors();
        for(Constructor constructor: constructors){
            System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());
        }
    }

    @Test
    public void testGetConstructor1() throws NoSuchMethodException {
        //getConstructor()返回单个构造器(只含public)
        Constructor constructor = Student.class.getConstructor();
        System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());
    }

    @Test
    public void testGetConstructor2() throws NoSuchMethodException {
        //getConstructor()返回单个构造器(只含public)
        Constructor constructor = Student.class.getConstructor(String.class,int.class);
        System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());
    }

    @Test
    public void testGetDeclaredConstructor() throws NoSuchMethodException {
        //getConstructors()返回单个构造器(只含public)
        Constructor constructor = Student.class.getDeclaredConstructor();
        System.out.println(constructor.getName()+"====>"+constructor.getParameterCount());
    }
}
