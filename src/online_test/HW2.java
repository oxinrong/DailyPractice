package online_test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(combine(n, m).size());
    }

    public static List<List<Integer>> combine(int n, int m) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrace(result, tmp, n, m, 1);
        return result;
    }

    private static void backTrace(List<List<Integer>> result, List<Integer> tmp, int n, int m, int start) {
        if (tmp.size() == m) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            backTrace(result, tmp, n, m, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
