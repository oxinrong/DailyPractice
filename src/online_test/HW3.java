package online_test;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();

        String[] es = tmp.split(",");

        System.out.println(getAns(es));
    }

    private static int getAns(String[] es) {
        int counted = 0, ans = 0;
        for (int i = 0; i < es.length; i++) {
            for (int j = 0; j < es[i].length(); j++) {

            }
        }
        while (counted < es.length) {

        }


        return ans;
    }

}
