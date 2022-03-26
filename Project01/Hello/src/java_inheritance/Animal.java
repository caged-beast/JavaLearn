package java_inheritance;

public abstract class Animal {//抽象类
    public abstract void run();
    public void eat(){//抽象类中可以有非抽象的成员方法
        System.out.println("Animal eat");
    }
}
