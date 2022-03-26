package java_genericity;

import java.util.ArrayList;
//泛型类
//模拟ArrayList
public class MyArrayList <E>{
    private ArrayList<E> arr = new ArrayList<>();
    public void add(E e){
        arr.add(e);
    }
    public void remove(E e){
        arr.remove(e);
    }
    public String toString(){
        return arr.toString();
    }
}
