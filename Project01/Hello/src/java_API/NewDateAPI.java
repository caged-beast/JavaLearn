package java_API;
//JDK 8后新增的LocalDate、LocalTime、LocalDateTime处理日期更好用

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

public class NewDateAPI {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();//只包含年月日
        LocalTime lt = LocalTime.now();//只包含时分秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getMonth().getValue());
        System.out.println("------------------------");
        //可以自己设置时间
        LocalDate ld1 = LocalDate.of(2022,2,28);
        LocalTime lt1 = LocalTime.of(19,33,48);
        LocalDateTime ldt1 = LocalDateTime.of(1999,9,9,8,8,8);
        System.out.println(ld1);
        System.out.println(lt1);
        System.out.println(ldt1);
        //这三个类型的对象可以转换
        LocalDate ld2 = ldt.toLocalDate();
        LocalTime lt2 = ldt.toLocalTime();
        System.out.println("------------------------");
        System.out.println(ld2);
        System.out.println(lt2);
        //加减字段值等操作
        System.out.println("------------------------");
        System.out.println(ld2.plusMonths(15));//返回新对象，原对象不变
        System.out.println(ld2.minusYears(2));
        System.out.println(ld2);
        System.out.println("今年是闰年吗？"+ld2.isLeapYear());
        LocalTime nowTime = LocalTime.of(19,48,0);
        System.out.println(lt2.equals(nowTime));
        System.out.println(lt2.isAfter(nowTime));
        //判断今天是不是生日
        System.out.println("------------------------");
        LocalDate birDate = LocalDate.of(1999,2,28);
        LocalDate nowDate = LocalDate.now();
        MonthDay birMD = MonthDay.of(birDate.getMonth(),birDate.getDayOfMonth());
        MonthDay nowMD = MonthDay.from(nowDate);
        System.out.println("今天是你的生日吗？"+nowMD.equals(birMD));
    }
}
