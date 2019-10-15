package online_test;

import java.util.Scanner;

public class XHS {
    private static int step = Integer.MAX_VALUE;
    private static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 1;
        }
        int[][] visited = new int[n][m];
        dfs(board, 0, 0, 0, visited);
        System.out.println(step == Integer.MAX_VALUE ? 0 : step);
    }

    private static void dfs(int[][] board, int x, int y, int count, int[][] visited) {
        if (x == board.length - 1 && y == board[0].length - 1) {
            step = step < count ? step : count;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (visited[newX][newY] != 1 && board[newX][newY] != 1) {
                    visited[newX][newY] = 1;
                    dfs(board, newX, newY, count + 1, visited);
                    int tmp = 1;
                    tmp--;
                    visited[newX][newY] = tmp;
                }
            }
        }
    }
}
