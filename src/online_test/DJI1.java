package online_test;

import java.util.Scanner;

public class DJI1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            int[] input = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                input[i] = Integer.parseInt(arr[i]);
            }

            int n = input[0], a = input[1], x = input[2];

            str = scanner.nextLine();
            arr = str.split(" ");
            int[] time = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                time[i] = Integer.parseInt(arr[i]);
            }

            if (x > 8) x = 8;
            System.out.println((int) Math.ceil(canSolve2(n, a, x, time)));
        }


    }

    private static double canSolve(int n, int a, int x, int[] time) {
        double res = 0, tmp = 0;
        int i;
        for (i = 0; x > 0 && i < n; i++) {
            res += (double)time[i] / a;
            tmp += (double)time[i] / a;
            if (tmp > 60) {
                x = x - (int) tmp / 60;
                tmp = tmp % 60;
            }
        }

        for (; i < n; i++) {
            res += time[i];
        }

        return res < 480 ? res : 0;
    }

    private static double canSolve2(int n, int a, int x, int[] time) {
        double allBugTime = 0, res = 0;
        int i;
        for (i = 0; i < n; i++) {
            allBugTime += (double)time[i];
        }

        if (allBugTime / a < x * 60) {
            res = allBugTime / a;
        } else {
            int effectiveTime = 60 * x;
            double normalTime = allBugTime - effectiveTime * a;
            res = effectiveTime + normalTime;
        }
        return res < 480 ? res : 0;
    }

}