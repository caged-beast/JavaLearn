package java_static;

import java.util.Random;

public class VerCodeTool {//利用静态成员方法工具类
    public VerCodeTool() {//构造器私有，防止创建对象，直接通过类名调用静态方法
    }
    public static String getVerCode(int size){
        String seed="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String ret = "";
        Random r =new Random();
        for(int i=0;i<size;i++){
            ret+=seed.charAt(r.nextInt(seed.length()));
        }
        return ret;
    }
}
