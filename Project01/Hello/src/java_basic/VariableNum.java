package java_basic;
//可变参数

import java.util.Arrays;

public class VariableNum {
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(sum(1));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}));
    }

    public static int sum(int... nums) {//可变参数只能放最后，且只能有一个
//        System.out.println(nums.length);//可变参数在方法内部本质上是个数组
//        System.out.println(Arrays.toString(nums));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
