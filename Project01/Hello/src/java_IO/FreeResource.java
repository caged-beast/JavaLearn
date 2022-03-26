package java_IO;
import java.io.*;
//原来的释放资源代码太繁琐，对其进行简化

public class FreeResource {
    public static void main(String[] args){
        try(//把资源对象放在try中（资源对象是指实现了closeable接口的对象），会在结束时自动调用close()
            InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\DL\\作业.png");
            OutputStream os = new FileOutputStream("F:\\test\\homework.png");
//            int a= 10;//只能放资源对象
            Myconnection mc = new Myconnection();
                ) {
            byte[] buffer = is.readAllBytes();
            os.write(buffer);
//            System.out.println(10 / 0);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

class Myconnection implements Closeable{

    @Override
    public void close() throws IOException {
        System.out.println("------关闭连接-------");
    }
}
