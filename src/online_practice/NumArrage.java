package online_practice;

import java.util.Scanner;

public class NumArrage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int sum = 0, sub = 1;

        while (n - sub > 0) {
            sum += (n - sub) * sub;
            sub ++;
        }

        if (n == 2) {
            System.out.println(2);
        } else if(n == 1) {
            System.out.println(1);
        } else {
            System.out.println(sum);
        }

    }
}
