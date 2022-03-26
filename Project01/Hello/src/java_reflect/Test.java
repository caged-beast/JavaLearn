package java_reflect;
//获取Class类对象的三种方法

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class的静态方法：Class.forName(包名+类名)
        Class c1 = Class.forName("java_reflect.Student");
        System.out.println(c1);//实际上c1就是Student.Class

        //2.类名.class
        Class c2 = Student.class;
        System.out.println(c2);

        //3.对象.getClass()
//        Class c3 = new Student().getClass();
//        System.out.println(c3);
    }
}
