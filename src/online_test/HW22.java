package online_test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(reverseStr(str));
    }

    private static String reverseStr(String str) {
        str = str.replaceAll("--", " ");

        String regEx = "[\n`~!@#$%^&*()+=|{}';':,\\[\\].<>/?]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String newStr = m.replaceAll("").trim();
        char[] tmp1 = newStr.toCharArray();
        for (int i = 1; i < tmp1.length - 1; i++) {
            if ('-'==tmp1[i] &&
                    (!(Character.isLetter(newStr.charAt(i - 1)) || Character.isDigit(newStr.charAt(i - 1))) ||
            !(Character.isLetter(newStr.charAt(i + 1)) || Character.isDigit(newStr.charAt(i + 1)))))
                            tmp1[i] = ' ';
        }
        newStr = "";
        for (int i = 0; i < tmp1.length; i++) {
           newStr += tmp1[i];
        }


        String[] tmp = newStr.split(" ");
        StringBuilder ans = new StringBuilder();

        // 倒置
        for (int i = tmp.length - 1; i >= 0; i--) {
            if(!"".equals(tmp[i]))
                ans.append(tmp[i] + " ");
        }

        return ans.toString();
    }
}
