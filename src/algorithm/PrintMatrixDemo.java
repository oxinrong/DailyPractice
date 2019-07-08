package algorithm;

import java.util.ArrayList;

/*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下 4 X 4 矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class PrintMatrixDemo {
    private static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {{1,2, 3,4,5}};
        System.out.println(printM(arr));
    }

    public static ArrayList<Integer> printM(int[][] matrix) {

        // 圈左上角
        int startX = 0, startY = 0;
        // 圈右下角
        int endX = matrix[startX].length - 1, endY = matrix.length - 1;

        while (startX <= endX && startY <= endY) {
            System.out.println(1);
            goThrogh(matrix, startX++, startY++,  endX--, endY--);
        }

        return res;
    }

    public static void goThrogh(int[][] matrix, int startX, int startY, int endX, int endY) {
        if (startY == endY) {
            while (startX <= endX) {
                res.add(matrix[startY][startX++]);
            }
            return;
        }

        if (startX == endX) {
            while (startY <= endY) {
                res.add(matrix[startY++][startX]);
            }
            return;
        }

        int oriY = startY;
        int oriX = startX;
        while (startX <= endX) {
            res.add(matrix[startY][startX++]);
        }

        startY++;
        startX--;
        while (startY < endY) {
            res.add(matrix[startY++][startX]);
        }

        while (endX >= oriX) {
            res.add(matrix[endY][endX--]);
        }

        endY--;
        endX++;
        while (endY > oriY) {
            res.add(matrix[endY--][endX]);
        }
    }
}
