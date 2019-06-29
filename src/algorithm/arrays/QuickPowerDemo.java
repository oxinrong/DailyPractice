package algorithm.arrays;

import java.math.BigInteger;
import java.util.Stack;

/*
    如果更快的求一个整数 k 的 n 次方。
    如果两个整数相乘并得到结果的时间复杂度为 O (1)，
    得到整数 k 的 N 次方的过程请实现时间复杂度为 O (logN) 的方法。

    给定 k 和 n，请返回 k 的 n 次方，
    为了防止溢出，请返回结果 Mod 1000000007 的值。
 */
public class QuickPowerDemo {

    public static void main(String[] args) {
        System.out.println(new QuickPowerDemo().getPower2(3, 3));
    }

    public int getPower1(int a, int n) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger tmp = BigInteger.valueOf(a);
        // 左移一位即除以二
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            res = res.mod(BigInteger.valueOf(1000000007));
            tmp = tmp.mod(BigInteger.valueOf(1000000007));
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public int getPower2(int k, int N) {
        if (N == 0) return 1;
        long sum = 1;
        long k2 = k;
        int mod = 1000000007;
        while (N != 0) {
            if ((N & 1) != 0)
                sum = (sum * k2) % mod;
            N = N >> 1;
            k2 = (k2 * k2) % mod;
        }
        return (int) sum;
    }
}

