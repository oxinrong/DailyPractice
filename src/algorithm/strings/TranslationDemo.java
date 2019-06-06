package algorithm.strings;

/*
    对于一个字符串，请设计一个算法，将字符串的长度为 len 的前缀平移到字符串的最后。
    给定一个字符串 A 和它的长度，同时给定 len，请返回平移后的字符串。
    要求空间复杂度为 O(1)，即不能使用辅助数组。
 */

public class TranslationDemo {

    public static void main(String[] args) {
        String a = "ABCDE";
        System.out.println(new TranslationDemo().stringTranslation(a, a.length(), 3));
    }

    public String stringTranslation(String A, int n, int i) {
        // 解法 1
        char[] arr = A.toCharArray();
        reverseAllChar(arr, 0, i - 1);
        reverseAllChar(arr, i, n - 1);
        reverseAllChar(arr, 0, n - 1);
        return String.valueOf(arr);

        // 解法 2
        //return (A + A).substring(i, i + n);
    }

    public void reverseAllChar(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
