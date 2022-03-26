package java_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Stream流初试
public class StreamTest1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三丰","张无忌","周芷若","张强");
        //1.找姓为张的人
        List<String> zNames = new ArrayList<>();
        for(String p:names){
            if(p.startsWith("张"))
                zNames.add(p);
        }
        System.out.println(zNames);
        //2.找姓为张且3个字的人
        for(String p:zNames){
            if(p.length()==3)
                System.out.println(p);
        }
        System.out.println("-------------------");
        //下面使用stream流
        names.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(s-> System.out.println(s));
    }
}
