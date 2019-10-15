package online_test;

import java.util.Scanner;

public class PDD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int n = canConcat(arr);
        if (n == -1) {
            System.out.println(true);
        } else {
            System.out.println(trySwitch(arr, n));
        }
    }

    public static int canConcat(String[] arr) {
        if (arr.length == 1) return -1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].charAt(arr[i].length() - 1)
                    != arr[i + 1].charAt(0))
                return i;
        }

        if (arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1)
                != arr[0].charAt(0))
            return 0;

        return -1;
    }

    public static boolean trySwitch(String[] arr, int index) {
        while (index < arr.length) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[index].charAt(arr[index].length() - 1)
                        == arr[i].charAt(0)) {
                    swap(arr, index + 1, i);
                }
            }
            index++;
        }

        return canConcat(arr) == -1;
    }

    public static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
