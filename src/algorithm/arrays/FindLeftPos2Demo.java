package algorithm.arrays;

/*
    有一个有序数组 arr，其中不含有重复元素，
    请找到满足 arr [i]==i 条件的最左的位置。
    如果所有位置上的数都不满足条件，返回 - 1。
    给定有序数组 arr 及它的大小 n，请返回所求值。
 */

public class FindLeftPos2Demo {

    public static void main(String[] args) {
        int[] arr = {-1,0,2,3};
        System.out.println(new FindLeftPos2Demo().findPos(arr, arr.length));
    }

    public int findPos(int[] arr, int n) {
        int res = -1;
        if (arr[0] > n - 1 || arr[n - 1] < 0) return res;
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= mid) {
                res = arr[mid] == mid ? mid : res;
                end = mid - 1;
                continue;
            }

            if (arr[mid] < mid) {
                start = mid + 1;
            }
        }
        return res;
    }
}
