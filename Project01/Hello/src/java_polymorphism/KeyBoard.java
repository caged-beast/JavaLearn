package java_polymorphism;

public class KeyBoard implements USB{
    private String name;

    public KeyBoard(String name) {
        this.name = name;
    }
    @Override
    public void connect() {
        System.out.println(name+"键盘已连接电脑");
    }
    @Override
    public void unconnect() {
        System.out.println(name+"键盘已从电脑拔出");
    }
    public void type(){
        System.out.println(name+"键盘打字");
    }
}
