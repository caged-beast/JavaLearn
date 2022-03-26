package java_thread;
//模拟取钱导致的并发修改异常

import java.util.Date;

public class ConcurrentModify {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-111",10000);
        new DrawMoneyThread(acc,"Joey").start();
        new DrawMoneyThread(acc,"Chandler").start();
    }
}
