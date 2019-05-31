package algorithm.arrays;

/*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.ArrayList;

public class ReOrderArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] arr2 = {1,2,3,5,4,6,7,9};

        reOrderArray(arr2);

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }

    }

    // 空间换时间
    public static void reOrderArray(int [] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even.add(array[i]);
            } else {
                odd.add(array[i]);
            }
        }

        for (int i = 0; i < odd.size(); i++) {
            array[i] = odd.get(i);
        }

        for (int i = 0; i < even.size(); i++) {
            array[odd.size() + i] = even.get(i);
        }
    }

    // 相对顺序不变，因此仅可顺次移动或交换相邻
    public static void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 前偶后奇交换
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
