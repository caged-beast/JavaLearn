package java_API;
//Collections工具类

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();//批量添加元素
        Collections.addAll(al,"Joey","Chandler","Ross","Monica","Rachel","Phoebe");
        System.out.println(al);
        Collections.shuffle(al);//打乱元素位置
        System.out.println(al);
        List<Apple> list = new LinkedList<>();
        list.add(new Apple("红富士",5));
        list.add(new Apple("红苹果",9));
        list.add(new Apple("黄苹果",9));
        list.add(new Apple("青苹果",11));
        Collections.sort(list);//排序
        System.out.println(list);
    }

}
