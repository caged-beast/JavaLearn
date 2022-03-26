package java_file;
//File操作文件

import java.io.File;
import java.text.SimpleDateFormat;

public class Test1 {
    public static void main(String[] args) {
        //绝对路径
//        File f1 = new File("C:\\Users\\Administrator\\Desktop\\Production Matching for Large Learning Systems.pdf");
        // 可以用/来替换\\
        File f1 = new File("C:/Users/Administrator/Desktop/Production Matching for Large Learning Systems.pdf");
        System.out.println(f1.length());//获得文件字节大小,如果是目录则返回0
        //也可以是文件夹
        File f2 = new File("C:\\Users");
        System.out.println(f2.exists());
        //相对路径,默认到工程下开始寻找文件，所以路径参数为“模块名\\文件名”
        File f3 = new File("Hello\\data.txt");
        System.out.println(f3.length());
        System.out.println("---------------------");
//        File f = new File("C:/Users/Administrator/Desktop/Production Matching for Large Learning Systems.pdf");
        File f = new File("Hello\\data.txt");
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());//文件名
        long pass = f.lastModified();//返回文件最后修改时间，时间毫秒值
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("最后修改时间："+sdf.format(pass));
    }
}
