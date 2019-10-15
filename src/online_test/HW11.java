package online_test;

import java.util.Scanner;

public class HW11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tmp = input.split("}");
        String A = tmp[0].substring(3);
        String B = tmp[1].substring(4);
        int R = Integer.parseInt(tmp[2].substring(3));

        System.out.println(getPairs(A, B, R));
    }

    private static String getPairs(String a, String b, int r) {
        int[] arrA = new int[(a.length() + 1) / 2];
        int index = 0;
        String[] tmp = a.split("");
        for (int i = 0; i < tmp.length; i++) {
            if (Character.isDigit(tmp[i].charAt(0))) {
                arrA[index++] = Integer.parseInt(tmp[i]);
            }
        }

        int[] arrB = new int[(b.length() + 1) / 2];
        index = 0;
        tmp = b.split("");
        for (int i = 0; i < tmp.length; i++) {
            if (Character.isDigit(tmp[i].charAt(0))) {
                arrB[index++] = Integer.parseInt(tmp[i]);
            }
        }

        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        while (i < arrB.length) {
            if (arrB[i] - arrA[j] <= r && arrB[i] >= arrA[j]) {
                res.append("(").append(arrA[j++]).append(",").append(arrB[i++]).append(")");
            } else if (arrB[i] >= arrA[j]) {
                res.append("(").append(arrA[j++]).append(",").append(arrB[i++]).append(")");
            } else {
                i++;
            }
        }
        return res.toString();
    }
}
