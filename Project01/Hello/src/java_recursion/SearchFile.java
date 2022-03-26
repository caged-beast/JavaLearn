package java_recursion;
//要返回某文件的绝对路径

import java.io.File;

public class SearchFile {
    public static final String FILE_NAME = "xl_ext_chrome.crx";//C盘中的某文件

    public static void main(String[] args) {
        File target = find("C:/", FILE_NAME);
        System.out.println(target==null?"该文件不存在":"文件位置: "+target.getAbsolutePath());
    }

    private static File find(String parent,String fileName) {//在某目录下找某文件
        File f = new File(parent);
        File[] files = f.listFiles();//该目录下的一级文件和目录
        //如果File对象f中的文件没有打开权限，那么listFiles返回null，这里要跳过
        if(files!=null){
            for (File file : files) {//遍历File对象
//            System.out.println(file.getAbsolutePath());
                if (file.isFile()) {//对文件进行检查
                    if (file.getName().equals(fileName))
                        return file;
                } else if (file.isDirectory() &&
                        find(file.getAbsolutePath(), fileName) != null) {//对目录进行递归
                    return find(file.getAbsolutePath(), fileName);
                }
            }
        }
        return null;
    }
}
