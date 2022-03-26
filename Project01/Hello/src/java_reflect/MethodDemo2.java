package java_reflect;
//使用反射技术获取成员方法后可以在某个对象中执行此方法

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo2 {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Student.class.getDeclaredMethod("study",String.class);
        Student s = new Student();
        //暴力达开权限
        method.setAccessible(true);
        //激活方法
        method.invoke(s,"数学");
    }
}
