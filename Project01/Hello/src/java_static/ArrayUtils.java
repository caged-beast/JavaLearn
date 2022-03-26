package java_static;

public class ArrayUtils {
    public ArrayUtils(){

    }
    public static String toString(int [] arr){//把数组转成字符串格式
        String ret = "[";
        if(arr!=null){
            for(int i=0;i<arr.length;i++)
                ret += (i == arr.length-1 ? i:i+",");
        }
        ret+="]";
        return ret;
    }
    public static double getAverage(int [] arr){//求数组平均值
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i])
                max = arr[i];
            if(min>arr[i])
                min = arr[i];
            sum+= arr[i];
        }
        return (sum * 1.0 / (arr.length)-2);
    }
}
