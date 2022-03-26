package java_polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.run();
        System.out.println(a.name);
        a = new Turtle();
        a.run();
        System.out.println(a.name);
        //a.layEggs();多态不能访问子类的特有方法
        //用instanceof防止强制类型转化错误
        if(a instanceof Dog){
            ((Dog)a).lookDoor();//要进行强制类型转换
        }
        else if(a instanceof Turtle){
            ((Turtle)a).layEggs();//要进行强制类型转换
        }
    }
}
