package java_IO;

import java.io.*;

// 以指定编码写入文件
public class OutputStreamWriterTest {
    public static void main(String[] args) throws Exception{

        OutputStream of = new FileOutputStream("Hello/mygbkfile.txt");// 先定义一个原始的字节输出流
        Writer osw = new OutputStreamWriter(of, "GBK");// 把它转换成指定编码的字符输出流
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("sdsa我爱中国");
        bw.write("sdsa我爱中国");
        bw.write("sdsa我爱中国");
        bw.close();
    }
}
