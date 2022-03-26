package java_exception;
//常见的运行时异常

public class RuntimeTest {
    public static void main(String[] args) {
        int[] a = {1,2,3};
//        System.out.println(a[3]);//ArrayIndexOutOfBoundsException
        String s = null;
//        System.out.println(s.length());//NullPointerException
//        System.out.println(10/0);//ArithmeticException
        Object o = 23;
//        String s1 = (String)o;//ClassCastException
        String num = "23a";
//        Integer it = Integer.valueOf(num);//NumberFormatException

        try{//运行时异常可以不处理，但在最外层捕获会使程序更健壮
            s.length();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
