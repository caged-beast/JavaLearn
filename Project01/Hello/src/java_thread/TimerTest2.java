package java_thread;
//Timer定时器基于单线程，任务间会相互影响，解决方法是创建线程池来实现定时器
//ScheduledExecutorService pool = Executors.newScheduledThreadPool();

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest2 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+
                        "正在执行AAA"+new Date());
                try {
                    Thread.sleep(30000);//多线程，任务间不会互相影响
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },2,2,TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+
                        "正在执行BBB"+new Date());
            }
        },2,2,TimeUnit.SECONDS);

    }
}
