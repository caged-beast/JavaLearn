package java_basic;

import java.util.Scanner;

public class Encryption {
    public static void printArray(int[] array) {
        System.out.println("-------");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i]);
        System.out.println();
        System.out.println("-------");
    }
    public static void reverse(int[] array)//反转数组
    {
        int size = array.length;
        int mid = size%2==0?size/2:size/2-1;//如果数组个数为奇数则最中间一个不用改变
        for(int i=0;i<mid;i++)
        {
            int temp = array[i];
            array[i] = array[size-1-i];
            array[size-1-i] = temp;
        }
    }
    public static void encrypt(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] + 5) % 10;
        }
        reverse(array);
    }
    public static void decrypt(int[] array) {
        reverse(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] + 5) % 10;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number you want to encrypt:");
        Scanner sc = new Scanner(System.in);
        String plaintext = sc.next();
        System.out.println(plaintext);

        int size = plaintext.length();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = plaintext.charAt(i) - 48;//字符0-9从ASCII码48开始
        }
//        printArray(array);
        encrypt(array);
        printArray(array);
        decrypt(array);
        printArray(array);
    }
}
