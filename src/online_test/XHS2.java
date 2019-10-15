package online_test;

import java.util.Scanner;

public class XHS2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getFinalMemo(s));

    }

    private static String getFinalMemo(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int isTag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                isTag++;
            }

            if (arr[i] == ')') {
                isTag--;
            }

            if (Character.isLetter(arr[i]) && isTag <= 0) {
                sb.append(arr[i]);
            }

            if (arr[i] == '<' && sb.length() > 0 && isTag <= 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }
}
