package algorithm;

public class BitDemo {

    // 不用任何额外变量交换两个整数的值
    public int[] getSwap(int[] num) {
        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }

    public int flip(int n) {
        return n ^ 1;
    }

    // 取得 32 位整数符号，不是负数返回 1，负数返回 0
    public int sign(int n) {
        return flip(n >> 31) & 1;
    }

    // 给定两个整数 a 和 b，请返回较大的数，不能用任何比较判断。
    public int getMax(int a, int b) {
        int c = a - b;
        // a 的符号 == 1 则为非负
        int sa = sign(a);
        // b 的符号
        int sb = sign(b);
        // a - b 的符号
        int sc = sign(c);
        // a 与 b 的符号是否不相同 == 1 则为不相同，== 0 为相同
        int difSab = sa ^ sb;
        // a 与 b 的符号是否相同 == 1 则为相同
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }


    // 有一个整型数组 A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，
    // 请打印这个数。
    // 要求时间复杂度为 O (N)，额外空间复杂度为 O (1)。
    public int findOdd(int[] A, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 异或运算满足交换律与结合律
            // n ^ n = 0
            // n ^ 0 = n
            res = res ^ A[i];
        }
        return res;
    }

    // 给定一个整型数组 arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，
    // 找到这两个数。
    // 要求时间复杂度为 O (N)，额外空间复杂度为 O (1)。
    public int[] findOdds(int[] arr, int n) {
        // eo = a ^ b, eo2 = a 或 b 其中一个
        int eo = 0, eo2 = 0;
        for (int i = 0; i < n; i++) {
            eo = eo ^ arr[i];
        }

        // 找到 eo 中不为 0 的比特位
        int tmp = eo & (~eo + 1);

        for (int i = 0; i < n; i++) {
            if ((arr[i] & tmp) != 0) {
                eo2 ^= arr[i];
            }
        }

        // 从小到大排序
        int small = Math.min(eo2, eo2 ^ eo);
        int big = Math.max(eo2, eo2 ^ eo);
        return new int[]{small, big};
    }

}
