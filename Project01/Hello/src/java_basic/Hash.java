package java_basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hash {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("hello"+i);
        }
        list.set(99, "java");
        //数组遍历查找元素
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.contains("java");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //用hash表查找元素
        int HASH_SIZE = 7;
        LinkedList<String>[] hashTable = new LinkedList[HASH_SIZE];//先建hash表
        for (int i = 0; i < list.size(); i++) {
            int index = Math.abs(list.get(i).hashCode()) % HASH_SIZE;
            if(hashTable[index]==null){
                hashTable[index] = new LinkedList<>();
            }
            hashTable[index].addLast(list.get(i));
        }
        long start1 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            int index = Math.abs("java".hashCode()) % HASH_SIZE;
            hashTable[index].contains("java");
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
