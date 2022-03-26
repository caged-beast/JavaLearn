package java_enum;
//用枚举做信息分类

import static java_enum.Direction.*;

public class Test {
    public static void main(String[] args) {

        move(LEFT);//枚举类型约束更强
    }
public static void move(Direction d){
    switch(d){
        case UP:
            System.out.println("上");
            break;
        case DOWN:
            System.out.println("下");
            break;
        case LEFT:
            System.out.println("左");
            break;
        case RIGHT:
            System.out.println("右");
            break;
    }
}
}
