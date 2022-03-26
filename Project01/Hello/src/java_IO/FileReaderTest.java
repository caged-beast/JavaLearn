package java_IO;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

//字符输入流，按字符读取，没有中文乱码问题
public class FileReaderTest {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("Hello/data.txt");
//        int code;
//        while((code = reader.read())!=-1) {
//            System.out.print((char) code);
//        }
        char[] buf = new char[1024];// 每次读取1024个字符
        int len;
        while((len= reader.read(buf))!=-1){
            System.out.print(new String(buf,0,len));
        }
    }
}
