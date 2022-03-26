package java_API;
//Map接口的常用API

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> shoppingCar = new HashMap<>();
        shoppingCar.put("xiaomi",1);
        shoppingCar.put("oppo",2);
        shoppingCar.put("vivo",2);
        shoppingCar.put("vivo",3);
        shoppingCar.put("apple",3);
        System.out.println(shoppingCar);
//        System.out.println(shoppingCar.isEmpty());
//        shoppingCar.clear();
//        System.out.println(shoppingCar.isEmpty());
//        System.out.println();
        System.out.println(shoppingCar.remove("oppo"));//根据键删除元素
        System.out.println(shoppingCar);
        System.out.println(shoppingCar.containsKey("apple"));
        System.out.println(shoppingCar.containsValue(3));
        System.out.println(shoppingCar.size());
        Set<String> name = shoppingCar.keySet();//获取全部键的集合
        System.out.println(name);
        Collection<Integer> numbers = shoppingCar.values();//获取全部值的集合
        System.out.println(numbers);
        Map<String ,Integer> plus = new HashMap<>();
        plus.put("mac",10);
        shoppingCar.putAll(plus);
        System.out.println(shoppingCar);
        //遍历Map有三种方式
        //1.分两步走
        System.out.println("---------------");
        Set<String> keys = shoppingCar.keySet();
        for(String key:keys){
            int value = shoppingCar.get(key);
            System.out.println(key+"----->"+value);
        }
        System.out.println("---------------");
        //2.先把每个键值对封装到一个entry对象
        Set<Map.Entry<String, Integer>> entries = shoppingCar.entrySet();
        for(Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
        System.out.println("---------------");
        //3.Lambda表达式
        shoppingCar.forEach((s,integer)->System.out.println(s+"---->"+integer));
    }
}
