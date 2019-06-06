package algorithm.strings;

/*
    对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
    也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
    给定一个原字符串 A 和他的长度，请返回逆序后的字符串。
 */
public class ReverseSentenceDemo {

    public static void main(String[] args) {
        String a = "dog loves pig";
        System.out.println(new ReverseSentenceDemo().reverseSentence(a, a.length()));
    }

    public String reverseSentence(String A, int n) {
        char[] words = A.toCharArray();
        reverseAllChar(words, 0, n - 1);

        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                reverseAllChar(words, start, i - 1);
                start = i + 1;
            }
        }
        reverseAllChar(words, start, words.length - 1);

        return String.valueOf(words);
    }

    public void reverseAllChar(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
