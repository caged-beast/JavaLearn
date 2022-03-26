package java_static;

//单例设计模式-饿汉
public class SingleInstance1 {
    public static SingleInstance1 instance = new SingleInstance1();//马上创建
    private SingleInstance1(){//构造器私有
    }
}
