package java_polymorphism;

public class Dog implements Animal{
    String name = "狗";
    @Override
    public void run() {
        System.out.println("Dog run fast");
    }
    public void lookDoor(){
        System.out.println("Dog is looking door");
    }
}
