package java_exception;
//键盘录入一个合理的价格

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        System.out.println("Please enter a price:");
        Scanner sc = new Scanner(System.in);
        while(true){
            String text = sc.nextLine();
            double price = 0;
            try {
                price = Double.valueOf(text);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println("Wrong input!");
            }
            if(price>0){
                System.out.println("price: "+price);
                break;
            }
            System.out.println("Enter again:");
        }
    }
}
