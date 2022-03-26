package java_thread;
//创建多线程方式1：子类继承Thread
//简单，但是子类继承了Thread就不能继承其它类了，不利于功能扩展

public class CreateThread1 {
    public static void main(String[] args) {
        //3.创建线程对象
        Thread mt = new MyThread();
        //4.调用start()
        mt.start();

        for (int i = 0; i < 5; i++) {//注意把子线程放在主线程之前
            System.out.println("主线程打印:" + i);
        }
    }
}

//1.创建子类继承Thread类
class MyThread extends Thread {
    //2.重写run()
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程打印:" + i);
        }
    }
}
