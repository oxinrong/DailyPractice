package algorithm.dp;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Changes {

    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20};
        int aim = 1000;

        System.out.println(processV(arr,aim));
    }

    // 暴力递归
    private static int processV(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return processV1(arr, 0, aim);
    }

    private static int processV1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            // 找零时判断最后一个数能否成功找零，如果刚好使得aim为0则成功找零，计数加一
            return aim == 0 ? 1 : 0;
        }

        for (int i = 0; arr[index] * i <= aim; i++) {
            res += processV1(arr, index + 1, aim - arr[index] * i);
        }

        return res;
    }

    // 记忆搜索
    // 不在乎路径，只记录递归过程
    private static int processM(int[]arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 是否算过这种组合标记
        // map[i][j] 的结果表示 process(i,j) 的返回结果
        int[][] map = new int[arr.length + 1][aim + 1];
        return processM1(arr, 0, aim, map);
    }

    private static int processM1(int[] arr, int index, int aim, int[][] map) {
        int res = 0;

        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }

        int mapValue;
        for (int i = 0; arr[index] * i <= aim; i++) {
            mapValue = map[index + 1][aim - arr[index] * i];
            if (mapValue != 0) {
                // 若之前已经计算过则直接取值使用
                res += mapValue == -1 ? 0 : mapValue;
            } else {
                res += processM1(arr, index + 1, aim - arr[index] * i, map);
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }


    // 动态规划
    // 规定好每一个递归过程的计算顺序，后面的计算严格依赖前面的计算
    // dp[i][j]：使用 arr[0..i] 货币情况下，组成钱数 j 有多少种方法？
    private static int processD(int[]arr, int aim) {
        return 0;
    }

}
