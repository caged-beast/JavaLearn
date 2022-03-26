package java_API;
//用Map来统计80个学生的选择

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapTest2 {
    public static void main(String[] args) {
        String[] choice = {"A","B","C","D"};
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {//先统计学生都选了什么
            sb.append(choice[r.nextInt(choice.length)]);
        }
        System.out.println(sb);
        //再把数据写入Map容器
        Map<Character ,Integer> infos = new HashMap<>();
        for(int i=0;i<sb.length();i++){
            Character k = sb.charAt(i);
            if(infos.containsKey(k)){
                infos.put(k,infos.get(k)+1);
            }
            else
                infos.put(k,1);
        }
        System.out.println(infos);//输入统计结果
    }
}
