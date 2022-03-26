package java_genericity;

import com.sun.security.jgss.GSSUtil;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("java");
        System.out.println(arr);
        arr.remove("java");
        System.out.println(arr);
        String[] arr1 = {"java","c","python"};
        Integer[] arr2 = {5,4,3,2,1};
        Integer[] arr3 = null;
        System.out.println(getArr(arr1));
        System.out.println(getArr(arr2));
        System.out.println(getArr(arr3));
        TeacherData t = new TeacherData();
        t.add(new Teacher());
    }
    public static <E> String getArr(E[] arr){//泛型方法
        if(arr!=null){
            StringBuilder sb = new StringBuilder("[");
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append(i==arr.length-1?"":",");
            }
            sb.append("]");
            return sb.toString();
        }
        else
            return null;
    }
}
