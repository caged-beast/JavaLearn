package java_thread;
//Timer定时器

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();//Timer就是一个单线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在执行AAA");
                try {
                    Thread.sleep(5000);//所有任务共用一个线程，前面的会影响后面的
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },2000,4000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在执行BBB");
            }
        },2000,4000);
    }
}
