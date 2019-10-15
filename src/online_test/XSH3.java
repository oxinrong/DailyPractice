package online_test;

import java.util.Scanner;

public class XSH3 {
    private static int step = Integer.MAX_VALUE;
    private static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int startX = 0, startY = 0;
    private static int endX = 0, endY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[n];
        int index = 0;
        while (n - index > 0) {
            str[index++] = scanner.nextLine();
        }
        int[][] arr = new int[n][str[1].length()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (str[i].charAt(j) == '.') {
                    arr[i][j] = 0;
                }

                if (str[i].charAt(j) == '#') {
                    arr[i][j] = 1;
                }

                if (str[i].charAt(j) == 'S') {
                    arr[i][j] = -1;
                    startX = i;
                    startY = j;
                }

                if (str[i].charAt(j) == 'E') {
                    arr[i][j] = -2;
                    endX = i;
                    endY = j;
                }
            }
        }
        int[][] visited = new int[n][arr[0].length];
        dfs(arr, startX, startY, 0, visited);
        System.out.println(step == Integer.MAX_VALUE ? 0 : step);
    }

    private static void dfs(int[][] board, int x, int y, int count, int[][] visited) {
        if (x == endX && y == endY) {
            step = step < count ? step : count;
            return;
        }
        int tmp = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            newX = newX < 0 ? board.length - 1 : newX;
            newX = newX > board.length - 1 ? 0 : newX;
            int newY = y + direction[i][1];
            newY = newY < 0 ? board.length - 1 : newY;
            newY = newY > board.length - 1 ? 0 : newY;
            if (visited[newX][newY] != 1 && board[newX][newY] != 1) {
                visited[newX][newY] = 1;
                dfs(board, newX, newY, count + 1, visited);
                tmp--;
                visited[newX][newY] = tmp;
            }
        }

    }
}