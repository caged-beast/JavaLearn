package java_API;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("java");
        list.add("mysql");
        list.add("mysql");
        list.add(2,"HTML");
        System.out.println(list);
        System.out.println(list.remove(2));//remove()返回被删除的元素
        System.out.println(list);
        System.out.println(list.set(0,"python"));//set()返回被删除之前的元素
        System.out.println(list);
        System.out.println(list.get(3));
        //遍历
        System.out.println("-------------------");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------------");
        for(String e:list){
            System.out.println(e);
        }
        System.out.println("-------------------");
        list.forEach(s-> System.out.println(s));
        System.out.println("-------------------");
        for(int i=0;i<list.size();i++){//除了上面collection的通用遍历方法以外，list带索引，还有其它的遍历方式
            System.out.println(list.get(i));
        }
        System.out.println("-------------------");
        //遍历的时候删除要注意并发修改异常，可以用迭代器或者普通for循环
        System.out.println(list);
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            String e = ite.next();
            if("mysql".equals(e)){
//                list.remove("mysql");
                ite.remove();//用迭代器的remove()不会后移
            }
        }
        System.out.println(list);
    }
}
