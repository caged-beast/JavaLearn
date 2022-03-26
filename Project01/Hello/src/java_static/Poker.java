package java_static;

import java.util.ArrayList;

public class Poker {
    public static ArrayList<String> cards = new ArrayList<>();//保存所有扑克牌的静态成员变量

    static{//初始化静态成员变量，54张牌
        String [] colors = {"Heart","Spade","Diamond","Club"};
        String [] num = {"3","4","5","6","7","8","9","10","J","Q","K","A"};
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                Poker.cards.add(num[i]+"-"+colors[j]);
            }
        }
        Poker.cards.add("Joker-Red");
        Poker.cards.add("Joker-Black");
    }

    public static void main(String[] args) {
        System.out.println(Poker.cards);
    }
}
