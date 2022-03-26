package java_stringBuilder;

public class Test2 {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println(getString(a));
    }
    public static String getString(int [] arr){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0;i<arr.length;i++){
            sb.append(i==arr.length-1?arr[i]:arr[i]+",");
        }
        sb.append("]");
        return sb.toString();
    }
}
