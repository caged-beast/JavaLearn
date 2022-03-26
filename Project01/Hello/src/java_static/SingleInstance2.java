package java_static;

//单例设计模式-懒汉
public class SingleInstance2 {
    private static SingleInstance2 instance;
    private SingleInstance2(){
    }
    public static SingleInstance2 getInstance(){//延迟创建
        if(instance==null)
            instance = new SingleInstance2();
        return instance;
    }
}
