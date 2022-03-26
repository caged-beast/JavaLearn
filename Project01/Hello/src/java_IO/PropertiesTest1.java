package java_IO;

import java.io.FileWriter;
import java.util.Properties;
//Properties属于Map家族
//保存属性信息
public class PropertiesTest1 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("chw","456465");
        properties.store(new FileWriter("Hello/user.properties"),
                "My Properties!");//第二个参数相当于备注

    }

}
