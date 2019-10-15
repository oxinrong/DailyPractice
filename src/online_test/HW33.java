package online_test;


import java.util.Scanner;

public class HW33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] original = new String[n];
        int index = 0;
        while(n-- > 0){
            original[index++] = scanner.nextLine();
        }
        int m = Integer.parseInt(scanner.nextLine());
        String[] trans = new String[m];
        index = 0;
        while (m-- > 0) {
            trans[index++] = scanner.nextLine();
        }

        original = transNewFly(original, trans);
        for (int i = 0; i < original.length; i++) {
            System.out.println(original[i]);
        }

    }

    private static String[] transNewFly(String[] original, String[] trans) {
        String[] res = new String[original.length];

        for (int i = 0; i < trans.length; i++) {
            res = transSingleNewFly(original, trans[i]);
        }



        return res;
    }

    private static String[] transSingleNewFly(String[] original, String singleTrans) {
        String[] res = new String[original.length];
        String[] trans = singleTrans.split(",");
        for (int i = 0; i < original.length; i++) {
            String tmpO = original[i];
            if (tmpO.contains(trans[0]) && tmpO.contains(trans[1])) {
                res[i] = trans[2] +"," + trans[3] + tmpO.substring(9);
            }
            original[i] = tmpO;
        }



        return res;
    }
}
