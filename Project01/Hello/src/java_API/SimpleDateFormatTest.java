package java_API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//SimpleDateFormatTest类用来格式化和解析时间
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        System.out.println(sdf.format(date));//format()既可以格式化Date对象，也可以格式化时间毫秒值
        System.out.println(sdf.format(date.getTime()));
        System.out.println(sdf.format(System.currentTimeMillis()));
        //求某个瞬间
        String dateStr = "2021年08月06日11点11分11秒";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
        Date curDate = sdf1.parse(dateStr);//手动throws ParseException
        date.setTime(curDate.getTime()+(2L*24*60*60+14*60*60+49*60+6)*1000);//避免超出int范围，最好加个L
        System.out.println(sdf1.format(date));
        //判断某时刻是不是在某个时间段内
        String startStr = "2020年11月11日 00:00:00";//活动的起始时间
        String endStr = "2020年11月11日 00:10:00";
        String p1Str = "2020年11月11日 00:03:47";//两个时刻
        String p2Str = "2020年11月11日 00:10:37";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date start = sdf2.parse(startStr);
        Date end = sdf2.parse(endStr);
        Date p1 = sdf2.parse(p1Str);
        Date p2 = sdf2.parse(p2Str);
        System.out.println("第一个人" + ((p1.after(start) && p1.before(end)||p1.equals(start)||p1.equals(end))?"赶上了":"没赶上") );
        System.out.println("第二个人" + ((p2.after(start) && p2.before(end)||p2.equals(start)||p2.equals(end))?"赶上了":"没赶上") );

    }
}
