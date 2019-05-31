package algorithm.search_and_sort;

public class HeapSort {
   static int[] A = {2,3,1,6,5,4,7};
    public static void main(String[] args) {
        A = heapSort(A, A.length);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int leftChild(int i) {
        return 2*i + 1;
    }

    public static void percDown(int[] arr, int start, int end) {

        int tmp;
        int child;
        for (tmp = arr[start]; leftChild(start) < end; start = child) {
            child = leftChild(start);
            // 取节点较大的子节点的下标
            if (child != end-1 && arr[child] < arr[child + 1]) {
                child++;
            }
            // 根节点 >= 左右子女中关键字较大者，则调整结束
            if (tmp < arr[child]) {
                // 将左右子结点中较大值array[child]调整到双亲节点上
                arr[start] = arr[child];
            } else {
                break;
            }
        }
        // 被调整的结点的值放入最终位置
        arr[start] = tmp;
    }

    public static int delMax(int[] arr, int n) {
        int max = arr[0];
        swap(arr, 0, --n);
        percDown(arr, 0, n);
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]);
        }
        return max;
    }

    public static int[] heapSort(int[] A, int n) {
        // 建立大根堆
        for ( int i = n / 2; i >= 0; i-- ) {
            percDown(A, i, n);
        }


        // 堆顶移至堆底，调整大根堆
//        n--;
//        while (n > 1) {
//            swap(A, 0, n--);
//            percDown(A, 0, n);
//        }
        for ( int  i = n - 1; i > 1;) {
            swap(A, 0, i--);
            percDown(A, 0, i);
        }
        return A;
    }
}
