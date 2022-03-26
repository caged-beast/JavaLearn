package java_stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//利用Stream流来处理数据
public class StreamTest4 {
    public static double sum = 0;

    public static void main(String[] args) {
        //部门1有4个人
        List<Employee> part1 = new ArrayList<>();
        part1.add(new Employee("Joey", 300, 400));
        part1.add(new Employee("Chandler", 700, 800));
        part1.add(new Employee("Ross", 400, 550));
        part1.add(new Employee("Monica", 400, 400));
        //1.筛选出最高工资的员工，封装成TopperFormer对象
        TopperFormer topperFormer = part1.stream()
                .max((o1, o2) -> Double.compare(o1.getBase() + o1.getBonus(), o2.getBase() + o2.getBonus()))
                .map(e -> new TopperFormer(e.getName(), e.getBase() + e.getBonus()))
                .get();//map()方法用来处理数据，结果是Optional类型的，要用get()方法来获取
        System.out.println(topperFormer);
        //2.统计部门平均工资，要去掉最高和最低工资
        part1.stream()
                .sorted((o1, o2) -> Double.compare(o1.getBase() + o1.getBonus(), o2.getBase() + o2.getBonus()))
                .limit(part1.size() - 1).skip(1)//掐头去尾
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee e) {
                        sum += e.getBase() + e.getBonus();
                    }
                });
        //在处理double类型的运算时可以用Bigdecimal处理精度问题
        System.out.println(BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(part1.size()-2), RoundingMode.HALF_UP));
    }
}
