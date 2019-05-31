package algorithm.search_and_sort;

/*
    请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为 O (1)。
    给定一个 int 数组 A 及它的大小 n，请返回它是否有重复值。

    思路： 没有空间限制可用 hash 表实现。
          数值范围小时可以用反数组实现，将值作为数组下标
          其他情况保证空间复杂度为 O(1)， 则将堆排序修改为非递归的方式实现。
          先排序，后判断是否重复。
 */

public class CheckDuplicateThroHeap {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 6, 6};
        CheckDuplicateThroHeap c = new CheckDuplicateThroHeap();
        System.out.println(c.checkDuplicate(arr, arr.length));

    }

    public boolean checkDuplicate1(int[] a, int n) {
        int max = a[0], min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min)
                min = a[i];
            if (a[i] > max)
                max = a[i];
        }

        int len = max - min + 1;
        int[] count = new int[len];
        int k = 0;
        for (int i = 0; i < n; i++) {
            k = a[i] - min;
            count[k] += 1;
            if (count[k] > 1) {
                return true;
            }
        }

        return false;
    }

    public boolean checkDuplicate(int[] a, int n) {
        if (a == null || n == 0) {
            return false;
        }
        // 排序
        heapSort(a);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        // 判断相邻是否相同
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public void heapSort(int[] arr) {
        // 构造大根堆
        for (int i = 0; i != arr.length; i++) {
            heapInsert(arr, i);
        }

        // 排序
        for (int i = arr.length - 1; i != 0; i--) {
            // 最大值移到末尾
            swap(arr, 0, i);
            // 大根堆化
            heapify(arr, 0, i);
        }
    }


    public void heapInsert(int[] arr, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
