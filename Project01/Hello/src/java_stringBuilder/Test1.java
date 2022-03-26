package java_stringBuilder;

public class Test1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append(1).append(3.14).append("ILOVECHINA");
        System.out.println(sb);
        sb.reverse();
        String sb1 = sb.toString();
        print(sb1);
    }
    public static void print(String s){
        System.out.println(s);
    }
}
