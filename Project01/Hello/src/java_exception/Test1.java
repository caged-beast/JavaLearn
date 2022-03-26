package java_exception;

public class Test1 {
    public static void main(String[] args) {
    int age = -10;
    try {
        fun(age);
    } catch (AgeIlleagalException e) {
        e.printStackTrace();
    }

    }
    public static void fun(int age) throws AgeIlleagalException {
        if (age < 0 || age > 100) {
            throw new AgeIlleagalException(age + " is illegal!");//抛出异常对象
        } else {
            System.out.println("age: " + age);
        }
    }
}
