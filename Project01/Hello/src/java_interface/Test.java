package java_interface;

public class Test {
    public static void main(String[] args) {
        //Athlete athlete = new Athlete();接口不能实例化
        ChineseAthlete c = new ChineseAthlete();
        c.fun1();
        Athlete.fun2();
    }
}
