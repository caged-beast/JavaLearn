package java_API;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UnmodifiedTest {
    public static void main(String[] args) {
        List<Integer> scores = List.of(98,99,100,65,88);
        System.out.println(scores);
        scores.add(66);//List、Set、Map的of方法创建的都是不可变集合
    }
}
