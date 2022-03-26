package java_thread;
//创建多线程的方式3：类实现Callable接口并结合FutureTask类
//前两种方法不能得到多线程返回的结果

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3.创建Callable任务对象
        Callable<Integer> mc = new MyCallable();
        //4.创建FutureTask对象，FutureTask实现了Runnable接口，且可以调用get()获取多线程返回结果
        FutureTask<Integer> ft = new FutureTask<>(mc);
        //5.创建Thread对象调用strat()
        new Thread(ft).start();
        System.out.println(ft.get());

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程打印:" + i);
        }
    }
}
//1.类实现Callable接口
class MyCallable implements Callable<Integer>{
    //2.重写call()
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
