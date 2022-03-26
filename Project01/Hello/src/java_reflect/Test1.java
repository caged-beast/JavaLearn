package java_reflect;
//使用反射绕过编译阶段往集合中添加元素
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        // 泛型只是在编译阶段对集合能操作什么类型数据做约束，在编译成class文件进入运行阶段时，
        // 无论是ArrayList<Integer>还是ArrayList<String>，都是ArrayList类型
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list1.getClass()==list2.getClass());
        System.out.println("------------------------");

        list1.add(13);
        list1.add(14);
//        list1.add("chw");//本来是不可以在ArrayList<Integer>类型的list1中加入字符串的
        //但是可以通过反射实现
        //1.先获取Class类对象
        Class c = list1.getClass();
        //2.再获取对象方法
        Method add = c.getDeclaredMethod("add", Object.class);
        //3.使用方法
        boolean ret = (boolean) add.invoke(list1, "chw");
        System.out.println(ret);
        System.out.println(list1);

        //其实要实现上面的功能还可以更简单
        ArrayList list3 = list1;//创建ArrayList对象指向list1
        list3.add("Aurora");
        System.out.println(list1);
    }
}
