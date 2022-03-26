package java_IO;
// 利用ObjectOutputStreamTest实现对象序列化

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Hello/obj.txt"));
        Student s1 = new Student("Joey",21);
        oos.writeObject(s1);
        oos.close();
    }
}

class Student implements Serializable {
    //申明序列化版本号，确保对象的更新
    private static final long serialVersionUID = 1;
    private String name;
    private transient int age;// transient修饰的变量不参与序列化

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
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
