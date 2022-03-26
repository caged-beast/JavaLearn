package java_OO;

import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        String keyAccount = "admin";
        String keyPassword = "chw";
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (cnt<3) {
            System.out.println("Please enter your account:");
            String account = sc.next();
            System.out.println("Please enter your password:");
            String password = sc.next();
            if (account.equals(keyAccount) && password.equals(keyPassword))//因为对象account存放的是地址，所以==比较在这里是不对的
                break;
            System.out.println("Wrong,try again!");
            cnt++;
        }
        if(cnt==3)
            System.out.println("Locked");
        else
            System.out.println("Welcome,"+keyAccount);

    }
}
