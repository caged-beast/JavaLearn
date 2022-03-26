package java_OO;

import java.util.Random;

public class VerCode {//利用String来实现验证码的功能

    public static void main(String[] args) {
        String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        System.out.println("---------------");
        for(int i=0;i<5;i++){//5位的Verification Code
            System.out.print(seed.charAt(r.nextInt(seed.length())));
        }
        System.out.println();
        System.out.println("---------------");
    }
}
