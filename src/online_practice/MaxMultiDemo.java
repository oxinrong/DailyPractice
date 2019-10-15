package online_practice;

import java.util.Scanner;

/*
    给出一个整数 n，将 n 分解为至少两个整数之和，使得这些整数的乘积最大化，
    输出能够获得的最大的乘积。
    例如：
        2=1+1，输出 1；
        10=3+3+4，输出 36。
 */

/*
    这个问题实际是一个动态规划问题。我们所要避免的是在和中尽可能少的出现 1，所以

    设 n = x1 + x2 + x3 + ... + xi + ... + xn，那么乘积为 x1 * x2 * x3 * ... xi * ...xn，
    若 xi >=5，则 xi = （xi - 3）+ 3 , 等式两边的乘积分别为 xi 和 3（xi - 3） = 3xi - 9 。
    若要使 3xi - 9 < xi , 则要 xi < 4.5，与 xi >= 5 矛盾，所以 xi >= 5，乘积最大不成立。

    当 n = 3 时，返回 2（3 = 2 + 1）;
    当 n = 4 时，则可以拆分成 2 x 2 = 4 >3 x 1；
    当 n = 5 时，我们需要尽可能的避免和中出现 1，所以 返回 6（5 = 2 + 3）；
    当 n = 6 时，可以拆分成 2 + 2 + 2 和 3 + 3 两种情况，很容易就可以知道 2 x 2 x 2 = 8< 3 x 3 = 9。

    所以我们可以得出当正整数 n 除以 3 得 k 余数为 1 时，我们需要将其转化为 k - 1 余数为 4，当余数为 0 或 2 时保持不变，
    这样得到的正整数的和的乘积即为最大乘积。
 */
public class MaxMultiDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countN(n));
    }

    private static int countN(int n) {
        if (n < 4) {
            return n - 1;
        }

        if (n % 3 == 0) {
            // 3*3 > 1*2
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            // 使得余数从 1 变为 4
            return (int) Math.pow(3, (n / 3 - 1)) * 4;
        } else {
            // 余数为 2 时保持不变
            return (int) Math.pow(3, n / 3) * 2;
        }
    }


}
