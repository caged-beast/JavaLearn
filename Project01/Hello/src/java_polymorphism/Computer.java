package java_polymorphism;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }
    public void start(){
        System.out.println(name+"电脑正在开机");
    }
    public void installDevice(USB device){
        if(device instanceof Mouse){
            device.connect();
            ((Mouse) device).dbClick();
            device.unconnect();
        }else if(device instanceof KeyBoard){
            device.connect();
            ((KeyBoard) device).type();
            device.unconnect();
        }
    }
}
