package java_API;
//Instance类提供对时间戳的处理

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class InstanceTest {
    public static void main(String[] args) {
        System.out.println(Instant.EPOCH);
        Instant instant = Instant.now();
        System.out.println("标准时间UT："+instant);
        System.out.println("地区时间CST："+instant.atZone(ZoneId.systemDefault()));
        Date date = Date.from(instant);//Date对象和Instant对象可以互换
        System.out.println(date);
        System.out.println(date.toInstant());
    }
}
