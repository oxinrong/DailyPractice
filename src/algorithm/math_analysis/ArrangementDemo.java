package algorithm.math_analysis;

public class ArrangementDemo {

    /**
     * 在 XxY 的方格中，以左上角格子为起点，右下角格子为终点，
     * 每次只能向下走或者向右走，请问一共有多少种不同的走法
     * 给定两个正整数 int x,int y，请返回走法数目。保证 x＋y 小于等于 12。
     */
    public int countWays(int x, int y) {
        //总的步数
        int sum = x + y - 2;
        //向下的步数,这里也可以是 right = x-1
        int down = y - 1;
        return fac(sum) / (fac(down) * fac(sum - down));
    }

    // 阶乘函数
    private int fac(int num) {
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }


    /**
     * n 个人站队，他们的编号依次从 1 到 n，
     * 要求编号为 a 的人必须在编号为 b 的人的左边，但不要求一定相邻，
     * 请问共有多少种排法？第二问如果要求 a 必须在 b 的左边，并且一定要相邻，请问一共有多少种排法?
     * 给定人数 n 及两个人的编号 a 和 b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。
     * 保证人数小于等于 10。
     */

    public int[] getWays(int n, int a, int b) {
        // 非左即右，答案为所有组合结果除以二
        // 两人绑定为一个人，答案为少了一个人的所有组合结果
        return new int[]{fac(n) / 2, fac(n - 1)};
    }

    /**
     * A (A 也是他的编号) 是一个孤傲的人，在一个 n 个人 (其中编号依次为 1 到 n) 的队列中，
     * 他于其中的标号为 b 和标号 c 的人都有矛盾，所以他不会和他们站在相邻的位置。
     * 现在问你满足 A 的要求的对列有多少种？
     * 给定人数 n 和三个人的标号 A,b 和 c，请返回所求答案，保证人数小于等于 11 且大于等于 3。
     */

    public int getWays(int n, int A, int b, int c) {
        // 所有组合
        int sum = fac(n);
        // 与 c 一起的所有组合（左边 + 右边）
        int ac = fac(n - 1) * 2;
        // 与 b 一起的所有组合（左边 + 右边）
        int ab = fac(n - 1) * 2;
        // ac 与 ab 的重复（abc 视作一个人）
        int overlap = fac(n - 2) * 2;
        return sum - ac - ab + overlap;
    }

    /**
     * n 颗相同的糖果，分给 m 个人，每人至少一颗，问有多少种分法。
     * 给定 n 和 m，请返回方案数，保证 n 小于等于 12，且 m 小于等于 n。
     */
    public int getWays(int n, int m) {
        // n 个糖，n-1 个空隙，m 个人， m-1 个隔板
        // C^{m-1}_{n-1}
        return fac(n - 1) / (fac(m - 1) * fac(n - m));
    }

    /**
     * 1. 假设有 n 对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，
     * 比如 n=1 时，() 是合法的，但是)(为不合法。
     * 给定一个整数 n，请返回所求的合法排列数。保证结果在 int 范围内。
     * 2. n 个数进出栈的顺序有多少种？假设栈的容量无限大。
     * 思想：卡特朗数，把进栈记为 ↓，出栈记为↑， 要出栈必须有相应的进栈操作，跟括号那道题就一样了，下同
     * 3. 2n 个人排队买票，n 个人拿 5 块钱，n 个人拿 10 块钱，票价是 5 块钱 1 张，
     * 每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
     * 4. 求 n 个无差别的节点构成的二叉树有多少种不同的结构？
     */
    public int countLegalWays(int n) {
        int A = 1;
        for (int i = n + 1; i <= n + n; ++i)
            A *= i;
        for (int i = 2; i <= n + 1; ++i)
            A /= i;
        return A;
    }

    // 12 个高矮不同的人，排成两排，每排必须是从矮到高排列，
    // 而且第二排比对应的第一排的人高，问排列方式有多少种？
    public int countWays(int n) {
        int A = 1;
        for (int i = n / 2 + 1; i <= n; ++i)
            A *= i;
        for (int i = 2; i <= n / 2 + 1; ++i)
            A /= i;
        return A;
    }

    // 有 n 个信封，包含 n 封信，现在把信拿出来，再装回去，
    // 要求每封信不能装回它原来的信封，问有多少种装法？
    public int countWays2(int n) {
        if (n == 1) {
            return 0;
        }
        long[] res = new long[n + 1];
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = (i - 1) * (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return (int) res[n];
    }

}
