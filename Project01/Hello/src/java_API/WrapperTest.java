package java_API;
//包装类是基本数据类型对应的引用类型
public class WrapperTest {
    public static void main(String[] args) {
//        int a = null;
        Integer a1 = null;//包装类对象容错更高
        Integer b = 13;
        System.out.println(b.toString()+1);//可以把基本类型的数据转成字符串
        System.out.println(1314+""+1);//把基本类型的数据转成字符串的另一种方式
        System.out.println(Integer.toString(14)+1);
        //可以把字符串数值解析成数据
        String str1 = "1314";
        System.out.println(Integer.parseInt(str1)+1);
        System.out.println(Integer.valueOf(str1)+1);
        String str2 = "13.14";
        System.out.println(Double.parseDouble(str2)+0.86);
        System.out.println(Double.valueOf(str2)+0.86);
    }
}
