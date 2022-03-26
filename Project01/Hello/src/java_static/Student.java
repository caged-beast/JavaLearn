package java_static;

public class Student {
    public static int inLineNum = 10;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public static void slogan(){
        System.out.println("I am a Chinese!");
    }
    public void study() {
        System.out.println(name+"is study");
    }

    public static void main(String[] args) {
//        System.out.println(this);静态方法不能使用this
        Student.slogan();
        System.out.println(Student.inLineNum);
        Student s = new Student("Chandler");
        s.study();
        System.out.println("VerCode: "+VerCodeTool.getVerCode(50));
        int [] arr = {10,20,30,40,66};
        System.out.println(ArrayUtils.toString(arr));
        System.out.println(ArrayUtils.getAverage(arr));
    }
}
