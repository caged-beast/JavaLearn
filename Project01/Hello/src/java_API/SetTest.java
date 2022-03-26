package java_API;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();//无序，不重复，无索引
//        Set<String> s = new LinkedHashSet<>();//有序，不重复，无索引
        s.add("mysql");
        s.add("html");
        s.add("html");
        s.add("java");
        s.add("java");
        System.out.println(s);

        Set<Student> set = new HashSet<>();//想要让存放对象的set去重必须重些对象的hashCode和equals方法
        Student s1 = new Student("Joey",31);
        Student s2 = new Student("Joey",31);
        Student s3 = new Student("Chandler",33);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set);
    }
}
class Student{
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
