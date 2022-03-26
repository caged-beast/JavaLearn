package java_thread;
//线程通信 生产者消费者模型
//模拟拨打、接听电话的功能

public class Phone {
    private boolean flag = false;//用于线程间通信，false表示当前没有未接听的电话
    public void turnOn() {//手机开机
        //手机对象中有两个线程，分别是拨打电话和接听电话
        new Thread(new Runnable() {
            @Override
            public void run() {//拨打电话
                while(true){
                    synchronized (Phone.this) {//对Phone对象加锁
                        if(!flag) {
                            System.out.println("有新电话呼入,嘟嘟嘟~~~");
                            flag = true;
                            //唤醒其它线程，并等待
                            Phone.this.notify();
                            try {
                                Phone.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {//接听电话
                while(true){
                    synchronized (Phone.this) {
                        if(flag) {
                            System.out.println("接听电话中，通话5分钟。。。");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                            //唤醒其它线程，并等待
                            Phone.this.notify();
                            try {
                                Phone.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            //唤醒其它线程，并等待
                            Phone.this.notify();
                            try {
                                Phone.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();

    }
    public static void main(String[] args) {
        Phone iphone = new Phone();
        iphone.turnOn();
    }
}
