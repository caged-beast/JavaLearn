package java_thread;
//使用Executors工具类提供的静态方法来创建线程池

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest3 {
    public static void main(String[] args) {
        //创建固定下线程数量的线程池
        ExecutorService p1 = Executors.newFixedThreadPool(3);
        p1.execute(new MyRunnable());
        p1.execute(new MyRunnable());
        p1.execute(new MyRunnable());
        //到这里线程用完了
        p1.execute(new MyRunnable());

    }
}
