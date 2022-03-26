package java_file;

import java.io.File;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        File f = new File("Hello\\data.txt");
        System.out.println(f.createNewFile());//创建文件，只能创建不存在的文件
        System.out.println(new File("Hello\\data2.txt").createNewFile());//几乎不用，因为文件都是自动创建的
        File d1 = new File("Hello\\aaa");
        System.out.println(d1.mkdir());//创建一级目录
        File d2 = new File("Hello\\bbb\\ccc\\ddd");
        System.out.println(d2.mkdirs());//创建多级目录
        System.out.println(new File("Hello\\data2.txt").delete());//删除文件
        System.out.println(new File("Hello\\aaa").delete());//删除空文件夹
        System.out.println(new File("Hello\\bbb\\ccc\\ddd").delete());//删除空文件夹

    }
}
