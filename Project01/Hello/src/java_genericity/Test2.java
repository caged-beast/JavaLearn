package java_genericity;
//泛型的通配符和上下界

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Benz> benzs = new ArrayList<>();
        benzs.add(new Benz());
        benzs.add(new Benz());
        benzs.add(new Benz());
        go(benzs);
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        go(bmws);
//        ArrayList<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        go(dogs);
    }
    public static void go(ArrayList<? extends Car> arr){//通配符？,extends和super可以划定匹配的上下界
//用ArrayList<Car>的话ArrayList<Benz>和ArrayList<BMW>都用不了该函数，因为外面多了一层ArrayList
    }
}
class Car{}
class Benz extends Car{}
class BMW extends Car{}
class Dog{}
