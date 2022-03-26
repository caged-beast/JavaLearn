package java_thread;

public class ThreadAPI1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt1 = new MyThread1();
        mt1.setName("1号");//设置线程名字
        mt1.start();
        MyThread1 mt2 = new MyThread1("2号");
        mt2.start();
        MyThread1 mt3 = new MyThread1("3号");
        mt3.start();

        Thread.sleep(3000);//当前线程休眠
        for(int i=0;i<5;i++)
            System.out.println(Thread.currentThread().getName()+"主线程打印:"+i);
    }
}

class MyThread1 extends Thread{
    public MyThread1() {
    }

    public MyThread1(String name) {//重写有参构造器让创建子类时可以设置线程名字
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++)
            System.out.println(Thread.currentThread().getName()+"子线程打印:"+i);
    }
}
