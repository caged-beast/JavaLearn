package java_anonymous;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal(){//匿名内部类
            @Override
            public void run() {
                System.out.println("Tiger run fast");
            }
        };
        a.run();
    }
}
