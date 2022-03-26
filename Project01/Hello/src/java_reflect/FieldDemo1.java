package java_reflect;
//使用反射技术获取成员变量

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldDemo1 {
    @Test
    public void testGetDeclaredFields(){
        //getDeclaredFields()返回所有成员变量的数组
        Field[] declaredFields = Student.class.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field.getName()+"======>"+field.getType());
        }
    }

    @Test
    public void testGetDeclaredField() throws NoSuchFieldException {
        //getDeclaredFields()返回所有成员变量的数组
        Field field = Student.class.getDeclaredField("name");//根据名称定位
        System.out.println(field.getName()+"======>"+field.getType());

    }
}
