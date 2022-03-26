package java_static;

public class CodeBlock {
    public static String name;
    static{//静态代码块和类一起加载，可用于初始化静态成员变量
        System.out.println("==========静态代码块加载===========");
        name = "Joey";
    }

    public static void main(String[] args) {
        System.out.println("==========main函数加载============");
        System.out.println(CodeBlock.name);
    }
}
