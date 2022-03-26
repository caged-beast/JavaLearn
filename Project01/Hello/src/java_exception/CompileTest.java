package java_exception;
//编译时异常示例

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//编译时异常的处理方法
public class CompileTest {
//    public static void main(String[] args) {//处理方法1：throws，把异常抛给调用者
//        String date = "2022-3-10 15:35:12";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM-dd HH:mm:ss");
//        Date parse = null;
//        try {
//            parse = sdf.parse(date);
//        } catch (Exception e) {//处理方法二：try/catch，自己捕获并处理
//            System.out.println("日期解析异常");
//        }
//        System.out.println(parse);
//    }
    //处理方法三：结合throws和try/catch
public static void main(String[] args) {
    System.out.println("开始");
    String date = "2022-3-10 15:35:12";
    try {
        fun(date);
    }catch(Exception e){
        e.printStackTrace();
    }
    System.out.println("结束");

}
public static void fun(String date) throws Exception{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM-dd HH:mm:ss");
    Date parse = sdf.parse(date);
    System.out.println(parse);
}
}
