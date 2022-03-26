package java_recursion;

import java.io.File;

//阶乘
public class Factorial {
    public static void main(String[] args) {
        System.out.println(fun(5));
        File f = new File("C:\\Users\\Administrator\\Desktop\\1");
        System.out.println(f.listFiles().length==0);
    }

    private static int fun(int i) {
        if(i>1)
            return i*fun(i-1);
        else
            return 1;
    }
}
