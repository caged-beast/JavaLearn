package java_genericity;
//泛型接口
public interface Data <E>{
    void add(E e);
    void remove(int id);
    void set(int id);
    E get(int id);
}
