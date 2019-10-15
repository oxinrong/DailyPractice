package online_test;

import java.util.Scanner;

public class IQIYI1 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] prr = new int[n];
        for (int i = 0; i < prr.length; i++) {
            prr[i] = i + 1;
        }
        int startIndex = 0;
        perm(arr, prr, startIndex, prr.length);
        System.out.println(count);

    }

    private static void perm(int[] arr, int[] prr, int startIndex, int n) {
        if (startIndex == n) {
            for (int j = 0; j < n - 1; j++) {
                if ((arr[j] == 0 && prr[j] > prr[j + 1]) || (arr[j] == 1 && prr[j] < prr[j + 1])) {
                    return;
                }
            }
            count++;
        } else {
            for (int i = startIndex; i < n; i++) {
                swap(i, startIndex, prr);
                perm(arr, prr, startIndex + 1, n);
                swap(i, startIndex, prr);
            }
        }
    }

    private static void swap(int index1, int index2, int[] prr) {
        int tmp = prr[index1];
        prr[index1] = prr[index2];
        prr[index2] = tmp;
    }
}
