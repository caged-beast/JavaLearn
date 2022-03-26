package java_IO;
//使用打印流可以方便、高效地打印数据

import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamTest {
    public static void main(String[] args) throws Exception{
        PrintStream ps = new PrintStream("Hello/ps.txt","UTF-8");
//        PrintWriter pw = new PrintWriter("Hello/ps.txt");//打印效果和PrintStream一样
        ps.println(1);
        ps.println(13.14);
        ps.println("hello");
        ps.println(true);
        ps.println('a');
        ps.close();

        //可以把系统打印流重定向到文件
        PrintStream sps = new PrintStream("Hello/log.txt");
        System.setOut(sps);
        System.out.println("hello world");
        sps.close();
    }
}
