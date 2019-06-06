package algorithm.strings;

/*
    对于一个给定的字符串数组，请找到一种拼接顺序，
    使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
    给定一个字符串数组 strs，同时给定它的大小，请返回拼接成的串。

    思路：若 str1 + str2 < str2 + str1，则 str1 应排在 str2 之前
 */


import java.util.Arrays;
import java.util.Comparator;

public class FindSmallestDemo {
    public static void main(String[] args) {
        String[] s = {"abc", "de"};
        System.out.println(new FindSmallestDemo().findSmallest(s, s.length));
    }

    public String findSmallest1(String[] strs, int n) {
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < n; i++) {

        }
        return "";
    }

    public class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public String findSmallest(String[] strs, int n) {
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
