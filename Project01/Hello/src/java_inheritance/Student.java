package java_inheritance;

public class Student extends People{
    public Student(String name){
        this(name,"北大");//调用同一个类里的有参构造器
    }
    public Student(String name,String school){
        this.name = name;
        this.school = school;
    }
    public void info(){
        System.out.println(name+":"+school);
    }
    private String name;
    private String school;
}
