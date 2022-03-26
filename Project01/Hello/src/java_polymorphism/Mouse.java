package java_polymorphism;

public class Mouse implements USB{
    private String name;

    public Mouse(String name) {
        this.name = name;
    }
    @Override
    public void connect() {
        System.out.println(name+"鼠标已连接电脑");
    }
    public void dbClick(){
        System.out.println(name+"鼠标双击");
    }

    @Override
    public void unconnect() {
        System.out.println(name+"鼠标已从电脑拔出");
    }
}
