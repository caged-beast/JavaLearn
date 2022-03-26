package java_API;
//字符串的编码、解码

import java_basic.Array;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "abc我爱你中国";

        //编码
//        byte[] bytes = s.getBytes();//默认以UTF-8编码
        byte[] bytes = s.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        //解码
//        String s1 = new String(bytes);
        String s1 = new String(bytes,"GBK");
        System.out.println(s1);
    }
}
