package online_test;

import java.util.Scanner;

public class YFD1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(rotatePrint(arr));
    }

    private static String rotatePrint(int[][] arr) {
        int row = arr.length;
        if (row == 0) return null;
        int col = arr[0].length;
        if (col == 0) return null;
        StringBuilder stringBuilder = new StringBuilder();
        int startRow = 0, endRow = row - 1;
        int startCol = 0, endCol = col - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // 一行
            if (startRow == endRow) {
                for (int i = startCol; i <= endCol; i++) {
                    stringBuilder.append(arr[startRow][i]).append(" ");
                }
                return stringBuilder.toString();
            }

            // 一列
            if (startCol == endCol) {
                for (int i = startRow; i <= endRow; i++) {
                    stringBuilder.append(arr[i][startCol]).append(" ");
                }
                return stringBuilder.toString();
            }

            // 首列
            for (int i = startRow; i <= endRow; i++) {
                stringBuilder.append(arr[i][startCol]).append(" ");
            }

            // 末行
            for (int i = startCol + 1; i < endCol; i++) {
                stringBuilder.append(arr[endRow][i]).append(" ");
            }

            // 末列
            for (int i = endRow; i >= startRow; i--) {
                stringBuilder.append(arr[i][endCol]).append(" ");
            }

            // 首行
            for (int i = endCol - 1; i >= startCol + 1; i--) {
                stringBuilder.append(arr[startRow][i]).append(" ");
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return stringBuilder.toString();
    }
}
