package java_inheritance;

public class SmartPhone extends Phone{//要重写，子类的访问权限必须大于父类
    public SmartPhone(String name){//子类的构造器默认会先调用父类的无参构造来初始化父类数据空间
        super(name);//可以手动修改为父类的有参构造
        System.out.println("SmartPhone的有参构造调用");
    }
    @Override
    public void call(){
        super.call();
        System.out.println("还支持视频通话");
    }
    @Override
    public void sendMessage(){
        super.sendMessage();
        System.out.println("还支持发图片");
    }
}
