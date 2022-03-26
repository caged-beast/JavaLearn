package java_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("Hello/myfile.txt");
        // 写入字节
        os.write('a');
        os.write(98);
//        os.write('许');
//        os.flush();// 要让写入的数据保存到磁盘必须刷新缓冲区

        // 写入字节数组
        byte[] buffer = new byte[]{'a',65,66,67};
        os.write(buffer);
        byte[] buffer2 = "我爱你中国".getBytes();
        os.write(buffer2);
        os.write("\r\n".getBytes());//换行
        os.write(buffer,1,3);

        os.close();// 关闭包含刷新
    }
}
