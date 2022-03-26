package java_thread;

import java.util.concurrent.Callable;

public class MyCallable1 implements Callable<Integer> {
    private int n;
    public MyCallable1(int n){
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName()+
                "线程计算1-"+n+"的和，结果是"+sum);
        return sum;
    }
}
