package java_polymorphism;

public class Turtle implements Animal{
    String name = "乌龟";
    @Override
    public void run() {
        System.out.println("Turtle run slow");
    }
    public void layEggs(){
        System.out.println("Turtle is laying eggs");
    }
}
