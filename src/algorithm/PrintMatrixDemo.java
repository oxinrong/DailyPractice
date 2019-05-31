package algorithm;

import java.util.ArrayList;

/*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下 4 X 4 矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class PrintMatrixDemo {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(printMatrix1(arr));
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int width = matrix[0].length - 1;
        int height = matrix.length - 1;
        System.out.println(width + "   " + height);

        int j = 0;
        int i = 0;
        int flag = 0;
        while (flag < height + width) {
            for (; i < width; i++) {
                res.add(matrix[j][i]);
            }


            for (; j <= height; j++) {
                res.add(matrix[j][i]);
            }

            j = flag + 1;
            i = 0;

            if (res.size() == width + height)
                break;

            flag++;
        }

        return res;
    }

    public static ArrayList<Integer> printMatrix1(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0)
            return result;
        int height = array.length, width = array[0].length;
        if (width == 0)
            return result;
        int layers = (Math.min(height, width) - 1) / 2 + 1; //这个是层数
        System.out.println(layers);
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < width - i; k++)
                result.add(array[i][k]); //左至右
            for (int j = i + 1; j < height - i; j++)
                result.add(array[j][width - i - 1]); //右上至右下
            for (int k = width - i - 2; (k >= i) && (height - i - 1 != i); k--)
                result.add(array[height - i - 1][k]); //右至左
            for (int j = height - i - 2; (j > i) && (width - i - 1 != i); j--)
                result.add(array[j][i]); //左下至左上
        }
        return result;
    }
}
