package algorithm.strings;

/*
    对于一个字符串，请设计一个高效算法，找到字符串的最长无重复字符的子串长度。

    给定一个字符串 A 及它的长度 n，请返回它的最长无重复字符子串长度。
    保证 A 中字符全部为小写英文字符，且长度小于等于 500。
 */

import java.util.HashMap;

public class LongestSubStringDemo {

    public static void main(String[] args) {
        String a = "aabcb";
        System.out.println(new LongestSubStringDemo().longestSubstring(a, a.length()));

    }

    public int longestSubstring(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }

        char[] arr = A.toCharArray();
        // 保存结点
        HashMap<Character, Integer> preIndex = new HashMap<>();

        int longest = 0, posA, res = 0;
        for (int i = 0; i < n; i++) {
            if (!preIndex.containsKey(arr[i])) {
                preIndex.put(arr[i], i);
                longest++;
            } else {
                posA = preIndex.get(arr[i]) + 1;
                if (posA > i - longest) {
                    longest = i - posA + 1;
                } else {
                    longest++;
                }
                preIndex.put(arr[i], i);
            }

            if (longest > res) {
                res = longest;
            }
        }

        return res;
    }

    public int longestSubstring1(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
}
