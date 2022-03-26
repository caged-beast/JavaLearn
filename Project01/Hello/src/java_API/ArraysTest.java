package java_API;
//Arrays类提供了大量对数组的操作API

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {25, 36, 14, 95, 78, 87, 10, 59, 2};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 95));//找到就返回索引，返回负数说明没找到
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//先排好序再用二分查找
        System.out.println(Arrays.binarySearch(arr, 95));//找到就返回索引，返回负数说明没找到
        //sort默认升序排序，要是想实现其它排序方式要加一个比较器的参数
        Integer[] arr1 = {25, 36, 14, 95, 78, 87, 10, 59, 2};//只能是引用型数据
//        Arrays.sort(arr1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        Arrays.sort(arr1, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr1));
    }
}
