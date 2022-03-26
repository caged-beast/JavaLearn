package java_recursion;

//啤酒2元1瓶，4个盖子或者2个空瓶可以换一瓶，十块钱可以喝多少瓶啤酒，剩多少空瓶和盖子?
//15瓶 3盖子 1瓶子
public class Beer {
//        循环
//    public static void main(String[] args) {
//        int beer = 0;
//        int bottle = 0;
//        int lid = 0;
//        int money = 10;
//        while (money >= 2 || bottle >= 2 || lid >= 4) {
//            while (money >= 2) {
//                money -= 2;
//                beer += 1;
//                bottle += 1;
//                lid += 1;
//            }
//            while (bottle >= 2) {
//                bottle -= 2;
//                beer += 1;
//                bottle += 1;
//                lid += 1;
//            }
//            while (lid >= 4) {
//                lid -= 4;
//                beer += 1;
//                bottle += 1;
//                lid += 1;
//            }
//        }
//        System.out.println("beer = " + beer);
//        System.out.println("bottle = " + bottle);
//        System.out.println("lid = " + lid);
//    }

    //    递归
    public static int beer = 0;//总的啤酒数
    public static int bottle = 0;//当前瓶子数
    public static int lid = 0;//当前盖子数

    public static void main(String[] args) {
        buy(10);
        System.out.println("beer = " + beer);
        System.out.println("bottle = " + bottle);
        System.out.println("lid = " + lid);
    }

    private static void buy(int money) {//拿钱买酒
        int buyNumber = money / 2;
        beer += buyNumber;
        int allBottle = bottle + buyNumber;
        int allLid = lid + buyNumber;
        money %= 2;
        if (allBottle >= 2) {
            money += allBottle / 2 * 2;//把瓶子换算成钱
        }
        bottle = allBottle % 2;
        if (allLid >= 4) {
            money += allLid / 4 * 2;//把盖子子换算成钱
        }
        lid = allLid % 4;
        if (money >= 2)
            buy(money);
    }
}
