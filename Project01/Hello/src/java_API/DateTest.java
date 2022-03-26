package java_API;
//Date类用来处理时间

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//获取时间毫秒值
        System.out.println(System.currentTimeMillis());
        date.setTime(1000*60*60*24);//设置时间
        System.out.println(date);
        //求过1小时121秒后的时间
        Date d = new Date();
        d.setTime(d.getTime()+60*60+121);
        System.out.println(d);
    }
}
