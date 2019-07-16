package algorithm.math_analysis;

import java.util.Random;

public class ProbabilityDemo {


    public static void main(String[] args) {
        System.out.println(new Random().nextInt(5));
    }

    /**
     * 有 2k 只球队，有 k-1 个强队，其余都是弱队，随机把它们分成 k 组比赛，
     * 每组两个队，问两强相遇的概率是多大？
     * 给定一个数 k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
     */
    public int[] calc(int k) {
        // 计算总组合数
        int sum = 1;
        for (int i = 2 * k - 1; i > 1; i -= 2) {
            sum *= i;
        }
        // 计算没有相遇数
        int notMeet = 1;
        int num = k + 1;
        for (int j = 1; j <= k - 1; j++) {
            notMeet *= (num--);
        }

        int gcd = gcd(sum - notMeet, sum);
        return new int[]{(sum - notMeet) / gcd, sum / gcd};
    }


    /**
     * n 只蚂蚁从正 n 边形的 n 个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
     */
    public int[] collision(int n) {
        // 每个蚂蚁两个方向， n 个蚂蚁 2^n 个方向，同时顺时针或同时逆时针不相遇
        int up = (int) Math.pow(2, n) - 2;
        int down = (int) Math.pow(2, n);
        int gcd = gcd(up, down);
        return new int[]{up / gcd, down / gcd};
    }

    // 辗转相除法求最大公约数
    public int gcd(int meet, int total) {
        if (meet % total == 0) {
            return total;
        }

        return gcd(total, meet % total);
    }


    /**
     * 给定一个等概率随机产生 1~5 的随机函数，
     * 除此之外，不能使用任何额外的随机机制，请实现等概率随机产生 1~7 的随机函数。
     */
    private static Random rand = new Random(123456);

    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public int randomNumber() {
        // rand5() - 1 随机生成 0、1、2、3、4
        // (rand5() - 1) * 5 随机生成 0、5、10、15、20
        // (rand5() - 1) * 5 + rand5() 随机生成 0、1、2、3、4、……、24
        int res = (rand5() - 1) * 5 + rand5();
        // 保证 7 的倍数
        while (res > 21) {
            res = (rand5() - 1) * 5 + rand5();
        }

        return res % 7 + 1;
    }


    /**
     * 给定一个以 p 概率产生 0，以 1-p 概率产生 1 的随机函数 RandomP::f ()，p 是固定的值，
     * 但你并不知道是多少。除此之外也不能使用任何额外的随机机制，
     * 请用 RandomP::f () 实现等概率随机产生 0 和 1 的随机函数。
     */
    private static double p = new Random().nextFloat();

    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        while (true) {
            // 虽然概率 p 不知道
            // 但是 01 或 10 的概率 p（1-p）是一样的
            int a = f();
            int b = f();
            if (a != b) {
                return a > b ? 1 : 0;
            }
        }
    }


    /**
     * 假设函数 f () 等概率随机返回一个在 [0,1) 范围上的浮点数，
     * 那么我们知道，在 [0,x) 区间上的数出现的概率为 x (0<x≤1)。
     * 给定一个大于 0 的整数 k，并且可以使用 f () 函数，
     * 请实现一个函数依然返回在 [0,1) 范围上的数，
     * 但是在 [0,x) 区间上的数出现的概率为 x 的 k 次方。
     */
    private Random rand1 = new Random(12345);

    public double f1() {
        return rand1.nextFloat();
    }

    // 请调用f()函数实现
    public double random(int k, double x) {
        double max = -1;
        // 调用 k 次取较大的值
        // 一次实验中，假如产生一个数 X0 ，那么有 P (X0<x)=x
        // 两次实验中，假如产生了两个数 X1，X2， 那么有 P(X1<x)=x，P(X2<x)=x
        // 而 P ((X1<x) && (X2<x)) = x^2， 等价于 X1，X2 中的最大数 < x, 此时的概率是 x^2
        // 因此要返回最大的数
        while (k-- > 0) {
            max = Math.max(f1(), max);
        }

        return max;
    }

    /**
     * 给定一个长度为 N 且没有重复元素的数组 arr 和一个整数 M，
     * 实现函数等概率随机打印 arr 中的 M 个数。
     */
    public int[] print(int[] arr, int N, int M) {
        int[] res = new int[M];
        int index = 0;
        while (index < M) {
            // 生成随机数
            int rand = new Random().nextInt(N - index);
            res[index] = arr[rand];
            // 原数组已复制的数与最后交换(?不明白为什么直接覆盖不交换不能通过
            swap(arr, rand, N - index - 1);
            index ++;
        }
        return res;
    }

    private void swap(int[] arr, int pos, int last) {
        int tmp;
        tmp = arr[pos];
        arr[pos] = arr[last];
        arr[last] = tmp;
    }

    /**
     * 有一个机器按自然数序列的方式吐出球，1 号球，2 号球，3 号球等等。
     * 你有一个袋子，袋子里最多只能装下 K 个球，并且除袋子以外，你没有更多的空间，
     * 一个球一旦扔掉，就再也不可拿回。设计一种选择方式，使得当机器吐出第 N 号球的时候，
     * 你袋子中的球数是 K 个，同时可以保证从 1 号球到 N 号球中的每一个，
     * 被选进袋子的概率都是 K/N。举一个更具体的例子，有一个只能装下 10 个球的袋子，
     * 当吐出 100 个球时，袋子里有 10 球，并且 1~100 号中的每一个球被选中的概率都是 10/100。
     * 然后继续吐球，当吐出 1000 个球时，袋子里有 10 个球，
     * 并且 1~1000 号中的每一个球被选中的概率都是 10/1000。继续吐球，
     * 当吐出 i 个球时，袋子里有 10 个球，并且 1~i 号中的每一个球被选中的概率都是 10/i。
     * 也就是随着 N 的变化，1~N 号球被选中的概率动态变化成 k/N。
     * N 个球时袋子中的球的编号返回。
     */

    private int [] selected = null;

    // 每次拿一个球都会调用这个函数，N表示第N次调用
    public int[] carryBalls(int N, int k) {
        if (selected == null) selected = new int[k];
        // 1. 处理 1~k 号球时直接放入袋子
        if (N <= k) {
            selected[N - 1] = N;
            return selected;
        }

        // 2. 处理第 N 号球时，以 k/N 的概率决定是否将第 N 号球放入袋子
        // 若决定不放则直接丢弃第 N 号球
        // 若决定放入则从袋子里的 k 个球中随机丢弃一个，然后把第 N 号球放入袋子
        if (k > rand.nextInt(N)) {
            selected[rand.nextInt(k)] = N;
        }

        return selected;
    }

}
