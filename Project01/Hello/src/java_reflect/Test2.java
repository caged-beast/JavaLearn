package java_reflect;
//要实现以下功能：对于给定的任何对象，都能保存其成员变量信息

import org.junit.Test;

public class Test2 {
        @Test
        public void test(){
            Student s = new Student("Joey",22);
            Teacher t = new Teacher("Ross",33,10000.0);
            SaveUtil.save(s);
            SaveUtil.save(t);
        }
//    public static void main(String[] args) {
//        Student s = new Student("Joey", 22);
//        Teacher t = new Teacher("Ross", 33, 10000.0);
//        SaveUtil.save(s);
//        SaveUtil.save(t);
//    }
}

