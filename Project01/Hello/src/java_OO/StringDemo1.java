package java_OO;

public class StringDemo1 {
    public static void main(String[] args) {
        String s1 = "I love China!";//字符串常量"I love China!"放在堆内存中，s1存放的其实是该常量的地址
        System.out.println(s1);//输出s1不是地址是因为做了特殊处理
        char [] arr = {'I',' ','L',' ','U'};
        String s2 = new String(arr);
        System.out.println(s2);
    }
}
