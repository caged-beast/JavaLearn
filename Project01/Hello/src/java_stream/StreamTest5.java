package java_stream;
//Stream流是处理集合或数组的工具，还需要把数据返回到集合或数组容器

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张三丰","张无忌","张无忌","王天一","曾维通","张强");
        Stream<String> stream = list.stream();
        //可以收集到集合
        List<String> names1 = stream.collect(Collectors.toList());
        System.out.println(names1);
//        Set<String> names2 = stream.collect(Collectors.toSet());//流只能使用一次
//        System.out.println(names2);
        //可以收集到数组
        Stream<String> stream1 = list.stream();
//        Object[] names3 = stream1.toArray();//stream流收集到数组默认是Object类型，但可以加入IntFunction<>对象来改变类型
        String[] names3 = stream1.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {//这里的value是容器大小
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(names3));
    }
}
