package java_stream;
//Stream流常用API

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张三丰","张无忌","张无忌","王天一","曾维通","张强");
        //count返回元素个数
        System.out.println(list.stream().count());
        //filter过滤
        list.stream().filter(s -> s.startsWith("张")).forEach(s-> System.out.println(s));
        //distinct去重
        System.out.println("--------------------");
        list.stream().filter(s -> s.startsWith("张")).distinct().forEach(s-> System.out.println(s));
        //limit获取前几个元素
        System.out.println("--------------------");
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);
        //skip跳过前几个元素
        System.out.println("--------------------");
        list.stream().filter(s -> s.startsWith("张")).skip(2).forEach(System.out::println);
        System.out.println("--------------------");
        //concat流的合并
        String[] arr = {"java","python"};
        Stream<String> sa = Stream.of(arr);
        Stream<String> sum = Stream.concat(list.stream(),sa);
        sum.forEach(s-> System.out.println(s));
    }
}
