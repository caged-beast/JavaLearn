package java_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

//Collection接口的常见操作
public class CollectTest {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("java1");
        c.add("java2");
        System.out.println(c);
        Collection<String> c2 = new ArrayList<>();
        c2.add("java3");
        c2.add("java4");
        c.addAll(c2);
        System.out.println(c);
//        System.out.println(c.isEmpty());
//        c.clear();
//        System.out.println(c.isEmpty());
        System.out.println(c.contains("java3"));
        c.remove("java3");
        System.out.println(c.contains("java3"));
        System.out.println(c.size());
        Object[] a = c.toArray();//Collection的toArray()方法得到的数组元素类型是Object
        System.out.println(Arrays.toString(a));
        //遍历集合
        Iterator<String> it = c.iterator();//迭代器
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------");
        for(String e:c){//增强for
            System.out.println(e);
        }
        System.out.println("-------------");
        double[] dArr= {1.1,2.2,3.3,4.4};//增强for也可以用于遍历数组
        for(double e:dArr){
            System.out.println(e);
            e = 6.6;//这里只是副本
        }
        System.out.println(Arrays.toString(dArr));
        System.out.println("-------------");
        c.forEach( s->System.out.println(s));//Lambda表达式
    }
}
