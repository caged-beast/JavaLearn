package java_OO;

public class StringAPI {
    public static void main(String[] args) {
        String s1 = "我爱你中国love";
        for(int i=0;i<s1.length();i++){//遍历字符串
            System.out.println(s1.charAt(i));
        }
        char[] chars = s1.toCharArray();//字符串转成字符数组
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println(s1.substring(3));//截取子串
        System.out.println(s1.substring(3,5));//包前不包后
        String s2 = "牛逼，大哥牛逼";
        System.out.println(s2.contains("牛逼"));//包含子串
        System.out.println(s2.contains("菜"));//包含子串
        System.out.println(s2.startsWith("牛逼"));//前缀
        System.out.println(s2.startsWith("菜"));//前缀
        System.out.println(s2.replace("牛逼","**"));//替换子串
        String s3 = "Joey,Chandler,Ross";
        String[] ch = s3.split(",");//分割子串
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
    }
}
