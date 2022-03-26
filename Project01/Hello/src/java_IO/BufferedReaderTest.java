package java_IO;
//缓冲字符输入流 BufferedReader，他新增了readLine()

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader("Hello/data.txt");
                BufferedReader br = new BufferedReader(reader);
        ) {
            String line;
            while((line=br.readLine())!=null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
