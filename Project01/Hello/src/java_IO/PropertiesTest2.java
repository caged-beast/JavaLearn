package java_IO;

import java.io.FileReader;
import java.util.Properties;

//加载属性文件数据
public class PropertiesTest2 {
    public static void main(String[] args) throws Exception{
        Properties p = new Properties();
        System.out.println(p);
        p.load(new FileReader("Hello/user.properties"));
        System.out.println(p);
        System.out.println(p.getProperty("chw"));
        System.out.println(p.getProperty("admin"));
    }
}
