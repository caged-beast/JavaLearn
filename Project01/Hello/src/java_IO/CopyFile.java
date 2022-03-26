package java_IO;
// 使用文件输入输出流完成对任意文件的拷贝(任意文件都以字节保存)

import java.io.*;

public class CopyFile {
    public static void main(String[] args){
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\DL\\作业.png");
            byte[] buffer = is.readAllBytes();
            os = new FileOutputStream("F:\\test\\homework.png");
            os.write(buffer);
//            System.out.println(10 / 0);
        } catch (Exception e){
            e.printStackTrace();
        } finally {

            //最好在finally中关闭stream,finally中的语句必定会执行
            try {
                if(os!=null)//处理空指针的情况
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("------------finally-------------");
        }

    }
}
