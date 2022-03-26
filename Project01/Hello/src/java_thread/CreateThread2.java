package java_thread;
//创建多线程方式2：类实现Runnable接口
//看扩展性更强，但是如果线程有执行结果是无法返回的

public class CreateThread2 {
    public static void main(String[] args) {
        //3.创建Runnable任务对象
        MyRun mr = new MyRun();
        //4.创建线程对象，调用start()
        new Thread(mr,"No.1").start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程打印:" + i);
        }
    }
}
//1.类实现Runnable接口
class MyRun implements Runnable {
    //2.重写run()
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"子线程打印:" + i);
        }
    }
}

