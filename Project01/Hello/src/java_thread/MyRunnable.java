package java_thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"线程正在打印: "+i);
        }
        try {
            System.out.println(Thread.currentThread().getName()+"线程正在休眠~~~");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
