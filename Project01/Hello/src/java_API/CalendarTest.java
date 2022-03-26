package java_API;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//Calendar类用来处理日历相关操作
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.HOUR,4);
        System.out.println(calendar.get(Calendar.HOUR));
        Date d = calendar.getTime();
        System.out.println(d);
    }
}
