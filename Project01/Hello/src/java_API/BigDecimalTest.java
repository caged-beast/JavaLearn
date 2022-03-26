package java_API;

import java.math.BigDecimal;
import java.math.RoundingMode;

//BigDecimal工具类用于处理精度失真
public class BigDecimalTest {
    public static void main(String[] args) {
        double d1 = 0.1;
        double d2 = 0.2;
        System.out.println(d1+d2);
        System.out.println(d1-d2);
        System.out.println(d1*d2);
        System.out.println(d1/d2);
        System.out.println("---------------------");
        System.out.println(BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2)));
        System.out.println(BigDecimal.valueOf(d1).subtract(BigDecimal.valueOf(d2)));
        System.out.println(BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)));
        System.out.println(BigDecimal.valueOf(d1).divide(BigDecimal.valueOf(d2)));
        System.out.println("---------------------");
        double d3 = 10.0;
        double d4 = 3.0;
        //BigDecimal必须要进行精度运算，这里10/3除不尽会报错
        //System.out.println(BigDecimal.valueOf(d3).divide(BigDecimal.valueOf(d4)));
        //下面对它取两位小数,并用doubleValue()方法转成double类型
        double ret = BigDecimal.valueOf(d3).divide(BigDecimal.valueOf(d4),2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(ret);
    }
}
