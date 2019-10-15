package online_practice;

/*
    给出一个正整数 n，请给出所有的包含 n 个 '(' 和 n 个 ')' 的字符串，使得 '(' 和 ')' 可以完全匹配。
    例如：
    '(())()'，'()()()' 都是合法的；
    '())()(' 是不合法的。
    请按照__字典序__给出所有合法的字符串。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LegalStringDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        DFS(0, 0, n, "", list);

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }

        System.out.println(list.get(list.size() - 1));
    }

    public static void DFS(int left, int right, int n, String str, List<String> list) {
        // 字符串合法时添加
        if (left == n && right == n) list.add(str);

        if (left < n && right <= left) {
            DFS(left + 1, right, n, str + '(', list);
        }

        if (right < n && right + left < 2 * n) {
            DFS(left, right + 1, n, str + ')', list);
        }

        return;
    }
}