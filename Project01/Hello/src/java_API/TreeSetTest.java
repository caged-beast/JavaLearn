package java_API;
import java.util.Set;
import java.util.TreeSet;

//对对象进行排序有两种方法：对象类实现comparable接口并重写compareTo方法，使用比较器对象
public class TreeSetTest {
    public static void main(String[] args) {
//        Set<Apple> set = new TreeSet<>((o1,o2)->o2.getPrice()-o1.getPrice());
        Set<Apple> set = new TreeSet<>();
        set.add(new Apple("红富士",5));
        set.add(new Apple("红苹果",9));
        set.add(new Apple("黄苹果",9));
        set.add(new Apple("青苹果",11));
        System.out.println(set);
    }
}

class Apple implements Comparable<Apple>{
    private String name;
    private int price;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Apple() {
    }

    public Apple(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Apple o) {
        return o.getPrice()-this.getPrice();//TreeSet对于返回值==0的情况视为重复，只保留一个
//        return o.getPrice()-this.getPrice()>=0?1:-1;//保留返回值为0的数据
    }
}
