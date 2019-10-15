package online_test;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] tmpS = s.split(" ");
        int[] arr = new int[tmpS.length];
        for (int i = 0; i < tmpS.length; i++) {
            arr[i] = Integer.parseInt(tmpS[i]);
        }
        System.out.println(getLeastStep(arr));
    }

    private static int getLeastStep(int[] arr) {
        int res = 0;
        int len = arr.length;
        int maxIndex = 0;
        for (int i = 1; i < len / 2; i++) {
            if (arr[maxIndex] >= len - maxIndex) return -1;
            maxIndex = arr[i] >= arr[maxIndex] ? i : maxIndex;
        }

        if (maxIndex > 0) res++;

        while (maxIndex < len - 1) {
            maxIndex += arr[maxIndex];
            res++;
        }

        if (maxIndex >= len) return -1;

        return res;
    }
}
