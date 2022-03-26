package java_inheritance;

public class Phone {
    private String m_Name;
//    public Phone() {
//        System.out.println("Phone的无参构造调用");
//    }
    public Phone(String name) {
        System.out.println("Phone的有参构造调用");
        m_Name = name;
    }

    public void call(){
        System.out.println(m_Name+"可以打电话");
    }
    public void sendMessage(){
        System.out.println(m_Name+"可以发短信");
    }
}
