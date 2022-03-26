package java_API;
//Period类可以用来计算日期间隔

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate bir = LocalDate.of(1999,9,9);
        Period dif  = Period.between(bir,now);
        System.out.println("你在这世上过了:"+
                dif.getYears()+"年"+dif.getMonths()+"个月"+dif.getDays()+"天");
    }
}
