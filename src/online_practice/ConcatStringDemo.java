package online_practice;

/*
    给出一个非空的字符串，判断这个字符串是否是由它的一个子串进行多次首尾拼接构成的。
    例如，"abcabcabc" 满足条件，因为它是由 "abc" 首尾拼接而成的，而 "abcab" 则不满足条件。
 */

import java.util.Scanner;

public class ConcatStringDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isConcatString(str));
    }

    private static String isConcatString(String str) {
        int subLen = str.substring(1).indexOf(str.charAt(0)) + 1, index = 0;
        String res = str.substring(0, subLen);
        if (subLen == 0 || str.length() % subLen != 0) return "false";

        while(index < str.length()) {
            for (int i = index; i < subLen + index; i++) {
                if (str.charAt(i) != res.charAt(i - index))
                    return "false";
            }
            index += subLen;
        }
        return res;
    }
}
