package java_thread;
// 多线程类，模拟取钱

public class DrawMoneyThread extends Thread{
    private Account acc;
    public DrawMoneyThread(Account acc, String name){//创建有参构造器，使得可以接受Account对象，并可以在创建线程时指定名字
        super(name);
        this.acc = acc;
    }
    @Override
    public void run() {
        acc.Draw(10000);
    }
}
