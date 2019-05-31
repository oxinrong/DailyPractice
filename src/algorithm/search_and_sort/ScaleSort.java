package algorithm.search_and_sort;

/*
    问题：
    已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
    每个元素移动的距离可以不超过 k，并且 k 相对于数组来说比较小。
    请选择一个合适的排序算法针对这个数据进行排序。
    给定一个 int 数组 A，同时给定 A 的大小 n 和题意中的 k，请返回排序后的数组。
    思路：
    改进后的小根堆
 */

public class ScaleSort {

    public static void main(String[] args) {
        ScaleSort scaleSort = new ScaleSort();
        int[] arr = {2, 1, 4, 3, 6, 5};
        int n = arr.length, k = 3;
        int[] res = scaleSort.sortElement(arr, n, k);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


    public int[] sortElement(int[] arr, int n, int k) {
        // 判断数组是否为空、数组大小与间隔大小比较等
        if (arr == null || n == 0 || n < k) {
            return arr;
        }

        // 构建大小为 k 的堆
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(heap, arr[i], i);
        }

        // 将 heap 的堆顶赋给 arr 的当前有效初始结点，将 arr 的当前结点给 heap 堆顶再小根堆化 heap
        for (int i = k; i < n; i++) {
            arr[i - k] = heap[0];
            heap[0] = arr[i];
            // 小根堆化
            heapify(heap, 0, k);
        }

        // 此时 arr 123465 heap 56

        for (int i = n - k; i < n; i++) {
            arr[i] = heap[0];
            swap(heap, 0, k - 1);
            heapify(heap, 0, --k);
        }

        return arr;
    }

    public void heapInsert(int[] heap, int value, int index) {
        // 初值
        heap[index] = value;
        // 到达根节点（首个结点）停止
        while (index != 0) {
            // 父节点
            int parent = (index - 1) / 2;
            // 若父节点值大于当前结点，交换两者的值，保证小根堆，并将当前结点置为父节点
            if (heap[parent] > heap[index]) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public void heapify(int[] heap, int index, int heapSize) {
        // 左儿子
        int left = index * 2 + 1;
        // 右儿子
        int right = index * 2 + 2;
        // 最小值所在结点，首先默认为初始结点
        int smallest = index;
        while (left < heapSize) {
            if (heap[left] < heap[index]) {
                smallest = left;
            }
            if (right < heapSize && heap[right] < heap[smallest]) {
                smallest = right;
            }
            // 若最小结点不是初始结点，则交换
            if (smallest != index) {
                swap(heap, smallest, index);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }


    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
