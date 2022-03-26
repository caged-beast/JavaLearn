package java_API;
//模拟斗地主游戏

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PokerGame {
    //创建List容器来存放54张牌
    public static List<Card> cards = new ArrayList<>();
    static {
        String[] literals = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♥","♠","♦","♣"};
        int pri = 0;
        for(String i:literals){
            for(String j:colors){
                cards.add(new Card(i,j,++pri));
            }
        }
        cards.add(new Card("☼","",++pri));//小王
        cards.add(new Card("☀","",++pri));//大王
    }
    public static void main(String[] args) {
        System.out.println("新牌: "+cards);
        //洗牌
        Collections.shuffle(cards);
        System.out.println("洗牌后: "+cards);
        //创建三个玩家和底牌对象，也是List容器
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        List<Card> remains = new ArrayList<>();
        //发牌
        for(int i=0;i<cards.size()-3;i++){
            if(i%3==0)
                player1.add(cards.get(i));
            else if(i%3==1)
                player2.add(cards.get(i));
            else
                player3.add(cards.get(i));
        }
        remains = cards.subList(cards.size()-3,cards.size());
        //排序
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);
        sortCards(remains);
        System.out.println("玩家一: "+player1);
        System.out.println("玩家二: "+player2);
        System.out.println("玩家三: "+player3);
        System.out.println("底牌: "+remains);
    }

    private static void sortCards(List<Card> player) {
        Collections.sort(player);
    }

}
