package online_test;


import java.util.Scanner;

public class LLS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String pNums = scanner.nextLine();
        int numA = pNums.charAt(0) - '0';
        int numB = pNums.charAt(2) - '0';

        String[] price = new String[n];
        int index = 0;
        while (n-- > 0) {
            price[index++] = scanner.nextLine();
        }
        System.out.println(getMinPrice(numA, numB, price));
    }

    private static int getMinPrice(int numA, int numB, String[] price) {
        int res = 0;
        int[] gap = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            String[] tmp = price[i].split(" ");
            gap[i] = Math.abs(Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[1]));
        }
        int n = price.length;
        while(n-- > 0) {
            int maxGap = 0, index = 0;
            for (int i = 0; i < gap.length; i++) {
                if (maxGap < gap[i]) {
                    maxGap = gap[i];
                    index = i;
                }
            }
            gap[index] = -1;

            String[] tmp = price[index].split(" ");
            if (Integer.parseInt(tmp[0]) < Integer.parseInt(tmp[1]) && numA > 0) {
                res += Integer.parseInt(tmp[0]);
                numA--;
            } else if (Integer.parseInt(tmp[0]) > Integer.parseInt(tmp[1]) && numB > 0) {
                res += Integer.parseInt(tmp[1]);
                numB--;
            } else if (numA > 0 && numB == 0) {
                res += Integer.parseInt(tmp[0]);
                numA--;
            } else if (numB > 0) {
                res += Integer.parseInt(tmp[1]);
                numB--;
            }
        }

        return res;
    }
}
