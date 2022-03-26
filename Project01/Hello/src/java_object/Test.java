package java_object;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Joey",30);
        Student s2 = new Student("Joey",30);
        System.out.println(s1);//直接输出对象默认接.toString()
        System.out.println(s2);//直接输出对象默认接.toString()
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
    }
}
