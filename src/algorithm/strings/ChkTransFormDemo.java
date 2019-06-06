package algorithm.strings;

/*
    对于两个字符串 A 和 B，如果 A 和 B 中出现的字符种类相同且每种字符出现的次数相同，
    则 A 和 B 互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。

    给定两个字符串 A 和 B 及他们的长度，请返回一个 bool 值，代表他们是否互为变形词。
 */

import java.util.HashMap;

public class ChkTransFormDemo {

    public static void main(String[] args) {
        String a = "DHJSKTQHEIXDEOE";
        String b = "XHIHOQSDTDEEJEK";
        String aa = "1 32 321";
        String[] aaa = aa.split(" ");

        for (int i = 0; i < aaa.length; i++) {
            System.out.println(aaa[i]);
        }
        System.out.println(new ChkTransFormDemo().chkTransform(a, a.length(), b, b.length()));
    }

    public boolean chkTransform1(String a, int lena, String b, int lenb) {
        if (a == null || b == null || lena != lenb) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < lena; i++) {
            count[a.charAt(i)]++;
        }

        for (int i = 0; i < lenb; i++) {
            if (count[b.charAt(i)]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean chkTransform(String a, int lena, String b, int lenb) {
        if (a == null || b == null || lena != lenb) {
            return false;
        }

        HashMap<Character, Integer> mapA = new HashMap<>();
        for (int i = 0; i < lena; i++) {
            if (!mapA.containsKey(a.charAt(i))) {
                mapA.put(a.charAt(i), 1);
            } else {
                mapA.put(a.charAt(i), mapA.get(a.charAt(i)) + 1);
            }
        }

        HashMap<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < lenb; i++) {
            if (!mapB.containsKey(b.charAt(i))) {
                mapB.put(b.charAt(i), 1);
            } else {
                mapB.put(b.charAt(i), mapB.get(b.charAt(i)) + 1);
            }
        }

        if (mapA.size() != mapB.size())
            return false;

        for (char c :
                mapA.keySet()) {
            if (mapB.get(c) != mapA.get(c))
                return false;
        }
        return true;
    }

}
