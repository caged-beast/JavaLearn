package java_polymorphism;

//多态案例
public class DemoTest {
    public static void main(String[] args) {
        Computer c = new Computer("外星人");
        USB device1 = new Mouse("罗技");
        USB device2 = new KeyBoard("腹灵");
        c.start();
        c.installDevice(device1);
        c.installDevice(device2);
    }
}
