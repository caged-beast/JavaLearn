package java_API;

import java.time.Duration;
import java.time.LocalDateTime;

//Duration类可以用来计算时间间隔
public class DurationTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime bir = LocalDateTime.of(1999,9,9,8,8,59);
        Duration dif = Duration.between(bir,now);
        System.out.println("你已经来人间"+dif.toDays()+"天");
        System.out.println("你已经来人间"+dif.toHours()+"小时");
    }
}
