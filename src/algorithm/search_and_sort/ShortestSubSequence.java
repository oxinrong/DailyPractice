package algorithm.search_and_sort;

/*
    对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
    给定一个 int 数组 A 和数组的大小 n，请返回一个二元组，代表所求序列的长度。
    (原序列位置从 0 开始标号，若原序列有序，返回 0)。保证 A 中元素均为正整数。
 */

public class ShortestSubSequence {

    public static void main(String[] args) {
        int[] arr = {1,4,6,5,9,10};
        int[] arr1 = {1,2,6,5,8,9};
        ShortestSubSequence sequence = new ShortestSubSequence();
        System.out.println(sequence.shortestSubsequence(arr1, arr1.length));
    }

    public int shortestSubsequence(int[] arr, int n) {
        int min = arr[n-1], max = arr[0];
        int right = 0, left = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < max) {
                right = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > min) {
                left = i;
            }
        }

        return right - left == 0 ? 0 : right - left + 1;
    }
}
