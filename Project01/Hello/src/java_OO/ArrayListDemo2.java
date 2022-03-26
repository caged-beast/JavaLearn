package java_OO;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("China");
        list.add("Not");
        list.add("America");
        list.add(1, "Love");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.remove(4));//删除元素
        System.out.println(list);
        System.out.println(list.remove("Not"));
        System.out.println(list);//修改元素
        list.set(0,"You");
        System.out.println(list);
    }
}
