package java_basic;
import java.util.Scanner;
public class MAX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("First:");
        int a = sc.nextInt();
        System.out.println("Second:");
        int b = sc.nextInt();
        System.out.println("Third5:");
        int c = sc.nextInt();
        int mid = a>b?a:b;
        int max = mid>c?mid:c;
        System.out.println("Max: "+max);
    }
}
