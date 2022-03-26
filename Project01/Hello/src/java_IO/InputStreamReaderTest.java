package java_IO;

import java.io.*;

//如果读取和存放的文件编码不一致，用字符流读写就会乱码，可以用字符转换流解决
public class InputStreamReaderTest {
    public static final String GBKFilePath = "F:/test/text.txt";

    public static void main(String[] args) {
        try (
//                BufferedReader br = new BufferedReader(new FileReader(GBKFilePath));
                InputStream is = new FileInputStream(GBKFilePath);//先提取原始的字节输入流
                Reader isr = new InputStreamReader(is,"GBK");//再用InputStreamReader转换成指定编码的字符输入流
                BufferedReader br = new BufferedReader(isr);
        ) {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
