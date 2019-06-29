package algorithm.arrays;

/*
    定义局部最小的概念。arr 长度为 1 时，arr [0] 是局部最小。
    arr 的长度为 N (N>1) 时，如果 arr [0]<arr [1]，那么 arr [0] 是局部最小；
    如果 arr [N-1]<arr [N-2]，那么 arr [N-1] 是局部最小；
    如果 0<i<N-1，既有 arr [i]<arr [i-1] 又有 arr [i]<arr [i+1]，
    那么 arr [i] 是局部最小。
    给定无序数组 arr，已知 arr 中任意两个相邻的数都不相等，
    写一个函数，只需返回 arr 中任意一个局部最小出现的位置即可。

 */

public class getLessIndexDemo {

    public static void main(String[] args) {
        int[] arr = {10,5,10,5,0,1,2,4,7,3,2,9,5,4,6,5,10,6,7,10,9,4,3,7,2,9,5,4,6,10};
        System.out.println(new getLessIndexDemo().getLessIndex(arr));
    }

    public int getLessIndex(int[] arr) {
        int end = arr.length-1;
        int start = 1, mid;
        if (-1 == end) return -1;
        if (0 == end || arr[0] < arr[1]) return 0;

        // 判断尾两端
        if (arr[end] < arr[end-1]) return end;
        end--;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid-1]) {
                end = mid - 1;
            } else if (arr[mid] > arr[mid+1]) {
                start = mid + 1;
            } else return mid;
        }

        return -1;
    }
}
