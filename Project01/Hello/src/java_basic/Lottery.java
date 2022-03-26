package java_basic;

import java.util.Random;
import java.util.Scanner;

//双色球:6个红球1个蓝球，红球1-33，蓝球1-16
public class Lottery {
    public static void printLotteryNumber(int[] array)//输出彩票号码
    {
        for (int i = 0; i < 6; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println(array[6]);
    }

    public static int[] getLuckyNumber() {
        boolean[] pool = new boolean[34];//建一个数字池，从中取数，防止重复，未取的数标为true
        for (int i = 0; i < 34; i++)//数组首位不用
            pool[i] = true;
        int[] array = new int[7];//存放彩票号码的数组
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(33) + 1;//红球取的数在1-33
            while (pool[num] == false)//保证每次取的数不重复
                num = r.nextInt(33) + 1;
            pool[num] = false;
            array[i] = num;
        }
        array[6] = r.nextInt(16) + 1;//蓝球取的数在1-16
        return array;
    }

    public static int[] getUserNumber() {
        boolean[] pool = new boolean[34];//建一个数字池，从中取数，防止重复，未取的数标为true
        for (int i = 0; i < 34; i++)//数组首位不用
            pool[i] = true;
        Scanner sc = new Scanner(System.in);
        int[] array = new int[7];
        int i = 0;
        while (i < 6) {
            System.out.println("Please Enter your " + (i + 1) + "st number:(between 1 and 33)");
            int num = sc.nextInt();
            while (num < 1 || num > 33 || pool[num] == false) {
                System.out.println("Wrong!");
                System.out.println("Please Enter your " + (i + 1) + "st number:(between 1 and 33)");
                num = sc.nextInt();
            }
            array[++i] = num;
            pool[num] = false;
        }
        System.out.println("Please Enter your " + (i + 1) + "st number:(between 1 and 16)");
        int num = sc.nextInt();
        while (num < 1 || num > 16) {
            System.out.println("Wrong!");
            System.out.println("Please Enter your " + (i + 1) + "st number:(between 1 and 16)");
            num = sc.nextInt();
        }
        array[6] = num;
        return array;
    }

    public static int numOfRight(int[] userNum, int[] luckyNum) {//有多少个红球号码是对的
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (luckyNum[i]==userNum[j])
                    sum++;
            }
        }
        return sum;
    }

    public static void judge(int[] userNum, int[] luckyNum) {
        int redRight = numOfRight(userNum, luckyNum);
        if(userNum[6]==luckyNum[6]){
            switch (redRight){
                case 0:
                case 1:
                    System.out.println("6st price:5 yuan");
                    break;
                case 2:
                case 3:
                    System.out.println("5st price:10 yuan");
                    break;
                case 4:
                    System.out.println("4st price:200 yuan");
                    break;
                case 5:
                    System.out.println("3st price:3000 yuan");
                    break;
                case 6:
                    System.out.println("1st price:10,000,000 yuan");
                    break;
            }
        }
        else{
            switch (redRight){
                case 4:
                    System.out.println("4st price:200 yuan");
                    break;
                case 5:
                    System.out.println("3st price:3000 yuan");
                    break;
                case 6:
                    System.out.println("2st price:5,000,000 yuan");
                    break;
                default:
                    System.out.println("Good luck next time!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your lottery numbers one by one:");
        int[] userNumber = getUserNumber();
        System.out.print("Your lottery numbers is: ");
        printLotteryNumber(userNumber);
        int[] luckyNumber = getLuckyNumber();
        System.out.print("The lucky numbers is: ");
        printLotteryNumber(getLuckyNumber());
        judge(userNumber,luckyNumber);
    }
}
