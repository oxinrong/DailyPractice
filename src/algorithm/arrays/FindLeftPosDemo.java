package algorithm.arrays;

/*
    对于一个有序数组 arr，再给定一个整数 num，
    请在 arr 中找到 num 这个数出现的最左边的位置。

    给定一个数组 arr 及它的大小 n，
    同时给定 num。请返回所求位置。若该元素在数组中未出现，请返回 - 1。
 */
public class FindLeftPosDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        System.out.println(new FindLeftPosDemo().findPos(arr, arr.length, 3));
    }

    public int findPos(int[] arr, int n, int num) {
        int res = -1;
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (num <= arr[mid]) {
                end = mid - 1;
                res = num == arr[mid] ? mid : res;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}
