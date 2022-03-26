package java_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String IDName;
    private double Money;
    //解决并发修改异常的方法3：Lock锁。实例化一个实现了Lock接口的对象（如ReentrantLock），调用其加、解锁方法
    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String IDName, double money) {
        this.IDName = IDName;
        Money = money;
    }
    //取钱
//    public synchronized void Draw(double money){//解决并发修改异常的方法2：同步方法。用synchronized修饰出现问题的方法
    public void Draw(double money){
        String name = Thread.currentThread().getName();
//        synchronized (this) {//解决并发修改异常的方法1：同步代码块。把出现问题的代码块放入synchronized(锁对象){}的方法体中，建议把共享资源当做锁对象，如对于实例方法建议把this作为锁对象，对于静态方法建议把类名.class对象作为锁对象
        lock.lock();
        try {
            if(this.Money>=money){
                    System.out.println(name+"取钱成功，取了"+Money);
                    this.Money -= money;
                    System.out.println(name+"取钱后余额为"+this.Money);
                }
                else
                    System.out.println(name+"取钱失败，余额为"+this.Money);
        } finally {//规范写法是吧lock.unlock()放在try/finally里
            lock.unlock();
        }
        }
//    }

    public String getIDName() {
        return IDName;
    }

    public void setIDName(String IDName) {
        this.IDName = IDName;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }
}
