package java_reflect;
//使用反射技术获取成员方法

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo1 {
    @Test
    public void testGetDeclaredMethods(){
        //getDeclaredMethods()返回所有成员方法的数组
        Method[] methods = Student.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+" 返回值类型:"+method.getReturnType()+
                    " 参数个数:"+method.getParameterCount());
        }
    }

    @Test
    public void testGetDeclaredMethod() throws NoSuchMethodException {
        //getDeclaredMethods()返回成员方法
        Method method = Student.class.getDeclaredMethod("study",String.class);//根据名称和参数类型定位
        System.out.println(method.getName()+" 返回值类型:"+method.getReturnType()+
                " 参数个数:"+method.getParameterCount());
    }
}
