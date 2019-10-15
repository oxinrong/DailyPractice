package online_test;

import java.util.Scanner;

public class Cisco1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] tmp = input.toCharArray();
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < tmp.length; i++) {
            res.append(tmp[i]);
            if (Character.isLetter(tmp[i])) {
                flag = false;
            } else if (!flag){
                break;
            }
        }

        int i;
        for (i = 0; i < res.length(); i++) {
            if (Character.isLetter(res.charAt(i))) {
                break;
            }
        }

        int j;
        for (j = i; j < res.length(); j++) {
            if (!Character.isLetter(res.charAt(j))) {
                break;
            }
        }


        System.out.println(res.toString().substring(i, j));
    }
}
