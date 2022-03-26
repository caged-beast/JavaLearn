package java_basic;

import java.util.Random;
import java.util.Scanner;

public class VerificationCode {
    public static String getAVerCode(int size)
    {
        String ret = "";
        for(int i=0;i<size;i++)
        {
            Random r = new Random();
            if(r.nextInt(3)==0)//随机出0就填一位数字，1就填一位大写字母，2就填一位小写字母
                ret += r.nextInt(10);
            else if(r.nextInt(3)==1)
            {
                int off = r.nextInt(26);//有26个字母
                ret += (char)(65+off);
            }
            else
            {
                int off = r.nextInt(26);//有26个字母
                ret += (char)(97+off);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Verification Code: "+getAVerCode(size));
    }
}
