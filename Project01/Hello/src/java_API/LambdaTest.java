package java_API;
//Lambda可用于简化匿名内部类的代码,注意只能简化函数式接口(只能有一个抽象方法的接口)的匿名内部类代码
//格式是：被重写方法的形参列表->{方法体}
public class LambdaTest {
    public static void main(String[] args) {
        Swimming teacher = ()-> System.out.println("Teacher run fast");
        teacher.run();
    }
}
@FunctionalInterface//函数式接口的注解，只能有一个抽象方法
interface Swimming{
    void run();
//    void run1();
}
