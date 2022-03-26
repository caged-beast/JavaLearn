package java_API;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Regular Expression正则表达式
//匹配规则可在API文档查看Pattern
public class RegexTest {
    public static void main(String[] args) {
        //判断某字符串是不是6到20位的数字
        System.out.println(check("123456489165"));
        System.out.println(check("12345a6489165"));
        System.out.println(check(null));
        System.out.println(check("1456"));
        System.out.println(checkWithRegex("123456489165"));
        System.out.println(checkWithRegex("12345a6489165"));
        System.out.println(checkWithRegex(null));
        System.out.println(checkWithRegex("1456"));
        System.out.println("----------------");
        //测试：数字、字母的4位组合
        System.out.println("4-Mn".matches("[a-zA-Z0-9]{4}"));
        System.out.println("45Mn".matches("[a-zA-Z0-9]{4}"));
        System.out.println("4-Mn".matches("[\\w&&[^_]]{4}"));
        System.out.println("45Mn".matches("[\\w&&[^_]]{4}"));
        System.out.println("----------------");
        //测试手机号、邮箱号
        System.out.println("18379964087".matches("1[3-9]\\d{9}"));
        System.out.println("11837996408".matches("1[3-9]\\d{9}"));
        System.out.println("1254729650@qq.com".matches("\\d{1,20}@[A-Za-z0-9]{2,20}(\\.[A-Za-z0-9]{2,20}){1,2}"));
        System.out.println("1254729650@qq.com.cn".matches("\\d{1,20}@[A-Za-z0-9]{2,20}(\\.[A-Za-z0-9]{2,20}){1,2}"));
        System.out.println("1254729650qq.com".matches("\\d{1,20}@[A-Za-z0-9]{2,20}(\\.[A-Za-z0-9]{2,20}){1,2}"));
        //String中和Regex相关的方法
        String ori = "小米dsjaoh41华为DJSKALDH1苹果dfsafB21s";
        String[] arr1 = ori.split("\\w+");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        String ret = ori.replaceAll("\\w+","  ");
        System.out.println(ret);
        System.out.println("-----------------");
        //常用模板
        String text = "小米dsjaoh41华为DJSKALDH1苹果dfsafB21s";
        String regex = "[^(\\w+)]{2}";
        Pattern pattern = Pattern.compile(regex);//根据模式编译出Pattern对象，用于模式匹配
        Matcher matcher = pattern.matcher(text);//Pattern对象匹配会生成Matcher对象，包含匹配项的信息
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    public static boolean checkWithRegex(String str){
        return str!=null && str.matches("\\d{6,20}");
    }
    public static boolean check(String str){
        if(str==null || str.length()<6 || str.length()>20)
            return  false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch<'0'||ch>'9')
                return false;
        }
        return true;
    }
}
