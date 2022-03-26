package java_reflect;
//要实现以下功能：对于给定的任何对象，都能保存其成员变量信息
//创建的工具类

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveUtil {
    public static void save(Object obj){
        //创建文件用于保存信息
        try {
          //在Junit Test方法中创建的文件和src目录同级，而在main()方法中创建的文件目录却和Module目录同级
            PrintStream ps = new PrintStream(new FileOutputStream("src/java_reflect/obj_data.txt",true));

            Class c = obj.getClass();//c.getSimpleName()获取类名
            ps.println("==============="+c.getSimpleName()+"================");
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String value = field.get(obj)+"";//无论成员变量什么类型，保存在文件中都是String
                ps.println(field+"=========>"+value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
