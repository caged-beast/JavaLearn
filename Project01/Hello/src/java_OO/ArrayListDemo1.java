package java_OO;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String > arrayList = new ArrayList<String >();
        arrayList.add("I");
        arrayList.add("China");
//        arrayList.add('!');
//        arrayList.add(123);
        arrayList.add(1,"Love");
        System.out.println(arrayList);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
//        list.add("sa");
        System.out.println(list);
    }
}
