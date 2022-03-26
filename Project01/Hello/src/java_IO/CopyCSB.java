package java_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 拷贝出师表
public class CopyCSB {
    public static final String SourceFilePath = "Hello\\CSB.txt";
    public static final String TargetFilePath = "F:\\test\\CSB.txt";

    public static void main(String[] args) {
        try (
                Reader r = new FileReader(SourceFilePath);
                BufferedReader br = new BufferedReader(r);
                Writer w = new FileWriter(TargetFilePath);
                BufferedWriter bw = new BufferedWriter(w);
        ) {
            //先读入源文件
            //按行存入List
            List<String> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            //对list中的String按序号排序
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.charAt(0) - o2.charAt(0);
                }
            });
            //把list中的String按行写入目标文件

            for (String s : list) {
//                System.out.println(s);
                bw.write(s);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
