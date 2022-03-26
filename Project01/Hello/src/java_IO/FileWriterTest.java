package java_IO;
//字符输出流

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        Writer w = new FileWriter("Hello/myfile2.txt");
        BufferedWriter bw = new BufferedWriter(w);
        bw.write('a');
        bw.write("hello");
        bw.write("hello",2,2);
        bw.newLine();//缓冲字符输出流多了newLine()
        bw.write(new char[]{'a','b',99});
        bw.write(new char[]{'a','b',99},2,1);
//        w.flush();
        bw.close();
    }
}
