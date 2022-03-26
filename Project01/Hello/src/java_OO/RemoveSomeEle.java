package java_OO;

import java.util.ArrayList;

public class RemoveSomeEle {//利用ArrayList删除某些元素

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(85);
        list.add(75);
        list.add(65);
        list.add(95);
        list.add(78);
        list.add(68);
        System.out.println(list);
        //要删除所有的低于80的数
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            if (list.get(i) < 80) {
//                list.remove(i);
//                i--;
//                size--;
//            }
//        }
        for (int i = list.size()-1; i >=0 ; i--) {//或者从后往前删
            if (list.get(i) < 80)
                list.remove(i);
        }
        System.out.println(list);
    }
}
