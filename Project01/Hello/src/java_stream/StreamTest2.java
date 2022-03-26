package java_stream;
//获取Stream流的方法

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        //Collection集合获取Stream流
        Collection<String > s1 = new ArrayList<>();
        Collections.addAll(s1,"java1","java2");
        s1.stream().forEach(s-> System.out.println(s));
        //Map集合获取Stream流
        Map<String,Integer> s2 = new HashMap<>();
        s2.put("Joey",31);
        s2.put("Chandler",33);
        s2.keySet().stream().forEach(s-> System.out.println(s));//键流
        s2.values().stream().forEach(s-> System.out.println(s));//值流
        s2.entrySet().stream().forEach(s-> System.out.println(s));//键值对流
        //数组获取Stream流
        Integer[] arr = {1,2,3,6,5,4,7,8,9,0};
        Stream<Integer> s3 = Arrays.stream(arr);
        s3.forEach(s-> System.out.println(s));
        Stream<Integer> s4 = Stream.of(arr);
        s4.forEach(s-> System.out.println(s));

    }
}
