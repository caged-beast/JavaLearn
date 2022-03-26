package java_reflect;

public class Student {
    private String name;
    private int age;

    private void eat(){
        System.out.println("好好吃饭");
    }
    private void study(){
        System.out.println("好好学习");
    }
    private void study(String name){
        System.out.println("好好学习"+name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
        System.out.println("========无参构造=======");
    }

    public Student(String name, int age) {
        System.out.println("========有参构造=======");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
