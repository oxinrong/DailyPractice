package algorithm.search_and_sort;

/*
    有一个只由 0，1，2 三种元素构成的整数数组，
    请使用交换、原地排序而不是使用计数进行排序。

    给定一个只含 0，1，2 的整数数组 A 及它的大小，请返回排序后的数组。
    保证数组大小小于等于 500。
 */

public class SortThreeColorDemo {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,2,2};
        int[] arr2 = {1,2,0,2};
        int[] arr3 = {2,2,0,2,0};
        int[] arr1 = {2,2,0,1,0,1,1,1};
        SortThreeColorDemo s = new SortThreeColorDemo();

        int[] res = s.sortThreeColor(arr3, arr3.length);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public int[] sortThreeColor(int[] arr, int n) {
        if (arr == null || n < 2) {
            return arr;
        }

        int flag0 = -1, flag2 = n, index = 0;
        while (index < flag2) {
            if (arr[index] == 0) {
                swap(arr, index++, ++flag0);
            } else if (arr[index] == 2) {
                swap(arr, index, --flag2);
            } else index++;
        }

        return arr;
    }

    public int[] sortThreeColor1(int[] A, int n) {
        if (A == null || A.length < 2) {
            return A;
        }
        int left = -1;
        int index = 0;
        int right = A.length;
        while (index < right) {
            if (A[index] == 0) {
                swap(A, ++left, index++);
            } else if (A[index] == 2) {
                swap(A, index, --right);
            } else {
                index++;
            }
        }
        return A;
    }


    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
