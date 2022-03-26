package java_static;

public class Test {
    public static void main(String[] args) {
        SingleInstance2 s1 = SingleInstance2.getInstance();
        SingleInstance2 s2 = SingleInstance2.getInstance();
        SingleInstance2 s3 = SingleInstance2.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
