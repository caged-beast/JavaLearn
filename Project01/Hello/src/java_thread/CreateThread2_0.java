package java_thread;
//创建多线程方式2的简介写法

public class CreateThread2_0 {
    public static void main(String[] args) {
        // 简化
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程1打印:" + i);
                }
            }
        };
        new Thread(r).start();

        //再简化
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2打印:" + i);
                }
            }
        }).start();

        //再简化
        new Thread(()-> {for (int i = 0; i < 5; i++) System.out.println("子线程3打印:" + i);}).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程打印:" + i);
        }
    }
}

