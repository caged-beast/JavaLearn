package java_OO;

import java.util.Scanner;

public class MaskNumber {//屏蔽手机号中间四位

    public static void main(String[] args) {
        System.out.println("Enter you phone number:");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        String mid = num.substring(3,7);
        System.out.println(num.replace(mid,"****"));
    }
}
