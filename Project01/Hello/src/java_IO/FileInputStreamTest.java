package java_IO;
//字节输入流
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("Hello/data.txt");
//        int b;
//        while((b=is.read())!=-1){//read()每次读取一个字节，读到末尾返回-1
//            System.out.println((char)b);// 每次读一个字节，所有读不了中文
//        }
        byte[] buffer = new byte[3];
        int len;// 记录每次读取到的字符长度
        while((len=is.read(buffer))!=-1){
            // 读多少倒多少
            System.out.print(new String(buffer,0,len));// 解决不了读中文乱码的问题
        }
    }
}
