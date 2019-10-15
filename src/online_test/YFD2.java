package online_test;

import java.util.Scanner;

public class YFD2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getNum(arr, s));
    }

    private static int getNum(int[] arr, int s) {
        if (arr == null || arr.length == 0) return 0;
        int res = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= s) {
                    res++;
                    max = res > max ? res : max;
                } else {
                    res = 0;
                    sum = 0;
                    break;
                }
            }
        }
        return max;
    }
}
