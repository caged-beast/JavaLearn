package java_basic;

import java.util.ArrayList;
import java.util.List;

public class Array {
    static void printArray(int [] array)
    {
        System.out.println("-------");
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
        System.out.println("-------");
    }
    public static void main(String[] args) {
        int [] array1 = new int [] {1,2,3};
        int array2 [] = {4,5,6};
        int [] array3 = new int[4];
        array3[0] = 11;
        array3[1] = 11;
        array3[3] = 11;
        printArray(array1);
        printArray(array2);
        printArray(array3);
    }
}
