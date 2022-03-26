package java_interface;

public interface Athlete extends People{//接口可以多继承，实现规范的合并
    //JDK 8之前接口只能包括常量和抽象方法
    public static final String name = "运动员";
    int age = 30;//前面不加public static final也是常量，会自动加
    public abstract void run();
    void eat();//前面不加public abstract也是抽象方法，会自动加

    //JDK 8 开始新增了默认方法和静态方法，JDK 9 开始新增了私有方法
    //默认方法，由接口的实现类调用
    default void fun1(){
        fun3();
        System.out.println("fun1");
    };
    //静态方法，用接口名调用，不能由接口的实现类调用是因为实现类可能会实现多个接口，多个接口可能会有同名方法，进而导致调用歧义
    static void fun2(){
        System.out.println("fun2");
    };
    //私有方法，由接口内部调用
    private void fun3(){
        System.out.println("fun3");
    };
}
