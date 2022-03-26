package java_basic;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int key = r.nextInt(100)+1;
        System.out.println("Please enter the number:");
        while (true){
            int answer = sc.nextInt();
            if(answer == key)
            {
                System.out.println("Right!");
                break;
            }
            else if(answer < key)
                System.out.println("Too less!");
            else
                System.out.println("Too large!");
            System.out.println("Enter again:");
        }
    }
}
