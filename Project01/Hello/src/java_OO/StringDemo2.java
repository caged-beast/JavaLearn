package java_OO;

public class StringDemo2 {
    public static void main(String[] args) {
        String s1 = "abc";//在堆内存的字符串常量池中
        String s2 = "ab";
        String s3 = s2 + "c";//带变量的运算，编译时不能确定s2的值，无法优化，所以结果在堆内存中
        System.out.println(s1==s2);//false
        String s4 = "a"+"b"+"c";//编译器会把"a"+"b"+"c"优化成"abc"
        System.out.println(s1==s4);//true
    }
}
