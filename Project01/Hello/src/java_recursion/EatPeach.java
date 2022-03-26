package java_recursion;
//猴子吃桃，每天吃一半再加一个，第10天发现只有1个，问原来有多少个

public class EatPeach {
    public static void main(String[] args) {
        //循环
        int sum = 1;
        for (int i = 0; i < 9; i++)
            sum = (sum + 1) * 2;
        System.out.println(sum);
        //递归
        System.out.println(numbers(1));
    }

    //f(x)-f(x)/2-1 = f(x+1)---------->f(x) = 2f(x+1)+2
    private static int numbers(int i) {//第i天桃子的个数
        if(i<10)
            return 2*numbers(i+1)+2;
        else
            return 1;
    }
}
