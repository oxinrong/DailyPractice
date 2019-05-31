package algorithm.search_and_sort;

/*
    现在有一个行和列都排好序的矩阵，请设计一个高效算法，
    快速查找矩阵中是否含有值 x。
    给定一个 int 矩阵 mat，同时给定矩阵大小 nxm 及待查找的数 x，
    请返回一个 bool 值，
    代表矩阵中是否存在 x。
    所有矩阵中数字及 x 均为 int 范围内整数。
    保证 n 和 m 均小于等于 1000。
 */

public class MetricSortDemo {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int hei = mat.length;
        int wid = mat[0].length;
        int x = 10;

        MetricSortDemo metricSortDemo = new MetricSortDemo();

        System.out.println(metricSortDemo.findX(mat, wid, hei, x));

    }

    public boolean findX(int[][] mat, int wid, int hei, int x) {
        if (mat == null) return false;

        int indexW = wid - 1, indexH = 0;

        while (indexH < hei && indexW >= 0) {
            if (x == mat[indexW][indexH])
                return true;

            if (x < mat[indexW][indexH]) {
                indexW--;
                continue;
            }

            if (x > mat[indexW][indexH]) {
                indexH ++;
            }
        }
        return false;
    }
}
