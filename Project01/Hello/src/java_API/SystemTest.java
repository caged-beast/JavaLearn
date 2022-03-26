package java_API;
//System工具类用于调用系统功能
import java.util.Arrays;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println("程序开始");
//        System.exit(0);
//        System.out.println("程序结束");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        }
        long end = System.currentTimeMillis();
        System.out.println("运行时间为："+(end-start)/1000.0+"s");
        long dif = System.currentTimeMillis();
        //System.currentTimeMillis()计算的是1970.01.01到当前时间的毫秒差值
        int year = (int) (dif/1000.0/60/60/24/365);
        int day = (int) (dif/1000.0/60/60/24%365);//这时输出是错误的因为不是每年都是365天
        int hour = (int) (dif/1000.0/60/60%24)+8;//算出来的小时是格林尼治标准时间GMT，而我们是东八区
        int min = (int) (dif/1000.0/60%60);
        int sec = (int) (dif/1000.0%60);
        System.out.println("Unix寿命："+year+"年"+day+"天"+hour+"小时"+min+"分"+sec+"秒");
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = new int[6];
        System.out.println(Arrays.toString(arr2));//Arrays.toString()方法可以把数组转换为字符串
        //想要arr2变成{0,0,4,5,6,0}
        System.arraycopy(arr1,3,arr2,2,3);
        System.out.println(Arrays.toString(arr2));
    }
}
