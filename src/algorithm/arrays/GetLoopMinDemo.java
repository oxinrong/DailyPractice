package algorithm.arrays;

/*
    对于一个有序循环数组 arr，返回 arr 中的最小值。
    有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组 [1,2,3,3,4]，是有序循环数组，[4,1,2,3,3] 也是。
    即：2、2、3、1、2 类似的情况
    给定数组 arr 及它的大小 n，请返回最小值。
 */

public class GetLoopMinDemo {

    public static void main(String[] args) {
        int[] arr = {2,2,2,1};
        System.out.println(new GetLoopMinDemo().getMin(arr, arr.length));
    }

    public int getMin(int[] arr, int n) {
        if (0 == n) return -1;
        if (1 == n) return arr[0];

        int start = 0, end = n - 1, mid;
        while (start < end) {
            if (start == end - 1) {
                break;
            }
            mid = start + (end - start) / 2;
            if (arr[start] < arr[end])
                return arr[start];
            else {
                if (arr[start] > arr[mid]) {
                    end = mid;
                } else if (arr[end] < arr[mid]) {
                    start = mid;
                    // 形如 2、2、2、1、2 的情况
                } else if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                    // 此时二分法没用，需要遍历全部
                    break;
                }
            }
        }

        int res = -1;
        while (start < end) {
            res = arr[start++] > arr[start] ? arr[start] : res;
        }
        return res;
    }
}
