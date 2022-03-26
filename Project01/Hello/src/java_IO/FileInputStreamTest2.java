package java_IO;
// 怎么解决文件字节输入流读取中文的乱码问题

import java.io.*;

public class FileInputStreamTest2 {
    public static void main(String[] args) throws IOException {
        File f = new File("Hello/data.txt");
        System.out.println("文件大小(字节数):"+f.length());
        InputStream is = new FileInputStream(f);
        //1. 一次性读取全部字符
//        byte[] buffer = new byte[(int)f.length()];
//        int len;
//        if((len = is.read(buffer))!=-1){
//            System.out.println("字节数组中的字节数:"+len);
//            System.out.print(new String(buffer));
//        }

        //2. API
        byte[] buffer = is.readAllBytes();
        System.out.print(new String(buffer));
    }
}
