package java_file;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {
        File f = new File("C:/Users/Administrator/Desktop");
        String[] list = f.list();//获得一个数组，存放的是当前目录下所有的一级文件的名称
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("-----------------------");
        File[] files = f.listFiles();//获得一个数组，存放的是当前目录下所有的一级文件的File对象
        for(File file:files){
            System.out.println(file.getName()+" : "+file.length());
        }
    }
}
