package java_IO;
import java.io.*;
// 用缓冲流来包装初始流，提高文件读写性能
public class CopyFile2 {
    public static void main(String[] args){
        try (
                InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\DL\\作业.png");
                // 用缓冲字节输入流来包装初始的字节输入流
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream("F:\\test\\homework.png");
                OutputStream bos = new BufferedOutputStream(os);
                ){
            byte[] buffer = bis.readAllBytes();
            bos.write(buffer);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
