package java_API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

//JDK 8 新增了日期时间的格式化工具DateTimeFormatter
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        //将LocalDateTime对象格式化成字符串
        System.out.println(ldt.format(dtf));
        System.out.println(dtf.format(ldt));
        //将字符串解析成LocalDateTime对象
        LocalDateTime ret = LocalDateTime.parse("1999-09-09 08-08-59",dtf);
        System.out.println(ret);
    }
}
