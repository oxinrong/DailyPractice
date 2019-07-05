import java.util.ArrayList;
import java.util.Scanner;


public class Bank2019Fall {
    /*
    农场有 n 只鸡鸭排为一个队伍，鸡用 “C” 表示，鸭用 “D” 表示。
    当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。
    每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，
    你需要计算出最少需要调整多少次可以让上述情况最少。
    例如：CCDCC->CCCDC->CCCCD 这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int result = 0;

        input = scanner.nextLine();
        String[] s = input.split("");

        int l = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("C")) {
                result += i - l;
                l++;
            }
        }

        System.out.println(result);
    }

    /*
        给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
        如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
        注意你不能在买入比特币前卖出。


     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> coin = new ArrayList<>();
        while (in.hasNextInt()) {
            coin.add(in.nextInt());
        }
        Integer[] co = new Integer[coin.size()];
        coin.toArray(co);
        int profit = 0;
        for (int i = co.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++) {
                profit = Math.max((co[i] - co[j]), profit);
            }
        System.out.println(profit);
    }

    /*
        小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p [i] 粒喵粮。
        喵主人离开了，将在 H 小时后回来。

        小招喵可以决定她吃喵粮的速度 K （单位：粒 / 小时）。
        每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。
        如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。

        小招喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。
        返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
     */
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> food = new ArrayList<>();
        while (in.hasNextInt()) {
            food.add(in.nextInt());
        }
        int num = food.size() - 1;
        Integer[] fo = food.toArray(new Integer[food.size()]);
        int planTime = fo[fo.length - 1];
        in.close();
        int realTime = planTime + 1;
        int speed;
        for (speed = 1; realTime > planTime; speed++) {
            realTime = 0;
            for (int i = 0; i < num; i++) {
                if ((fo[i] % speed) != 0 && fo[i] > speed) {
                    realTime += fo[i] / speed + 1;
                } else if (fo[i] < speed)
                    realTime++;
                else
                    realTime += fo[i] / speed;
            }
        }
        System.out.println(--speed);
    }
}
