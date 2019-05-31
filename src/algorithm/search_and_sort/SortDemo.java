package algorithm.search_and_sort;

public class SortDemo {

    public static int[] sortElement( int[] A, int n, int k ) {
        // 建立大根堆
        int j = 0;
        for ( j = (j + k) / 2 - 1; j >= 0; j-- ) {
            buildHeap(A, j, j + k);            
        }
        return A;
    }

    public static int leftChild(int i) {
        return 2*i+1;
    }

    public static void buildHeap(int[] arr, int start, int end) {
        int tmp;
        int child;
        for (tmp = arr[start]; leftChild(start) > end; start = child) {
            child = leftChild(start);
            if (child != end - 1 && arr[child] > arr[child + 1]) {
                child++;
            }
            if (tmp > arr[child]) {
                arr[start] = arr[child];
            } else {
                break;
            }
        }
        arr[start] = tmp;
    }
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void main(String[] args) {
        int[] A = {6,4,5,2,3,0,1};
        int n = A.length;
        int k = 3;
        int[] res = insertionSort(A, n);
        
        for ( int i = 0; i < n; i++ ) {
            System.out.print(res[i]);
        }
       
    }

    public static int partition(int[] A, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = A[lo];

        while (true) {
            while (v < A[--j])
                if (j == lo)
                    break;
            while (v > A[++i])
                if (i == hi)
                    break;
            if (i >= j)
                break;
            swap(A, i, j);
        }
        swap(A, lo, j);
        return j;
    }

    public static void quick3way(int[] A, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        int v = A[lo];

        while (i <= gt) {
            if (A[i] < v) {
                swap(A, lt++, i++);
            } else if (A[i] > v) {
                swap(A, i, gt--);
            } else i++;
        }

        quick3way(A, lo, lt - 1);
        quick3way(A, gt + 1, hi);
    }

    public static int[] insertionSort(int[] A, int n) {
        int j;
        for (int i = 1; i < n; i++ ) {
            int tmp = A[i];
            // 将现有元素往后移动，直到插入位
            for ( j = i; j > 0; j-- ) {
                if (tmp >= A[j-1])
                    break;
                A[j] = A[j-1];
            }
            A[j] = tmp;

//            for (int k = 0; k < A.length; k++) {
//                System.out.print(A[k]);
//            }
//            System.out.println();
        }
        return A;
    }

    public static int[] countingSort (int[] A, int n ) {
        int max = -1;
        for ( int i = 0; i < A.length; i++ ) {
            if (A[i] > max)
                max = A[i];
        }

        int[] bucket = new int[max+1];
        for ( int i = 0; i < A.length; i++ ) {
            bucket[A[i]] ++;
        }

        int[] res = new int[n];
        int index = 0;
        for ( int i = 0; i < bucket.length; i++ ) {
            while ( bucket[i] != 0 ) {
                res[index++] = i;
                bucket[i]--;
            }
        }
        return res;
    }

    public static int[] radixSort ( int[] A, int n ) {

        int[] bucket = new int[10];
        int[] res = new int[n];

        for ( int i = 0; i < bucket.length; i++ ) {
            bucket[i] = i;
        }

        int max = -1;
        for ( int i = 0; i < A.length; i++ ) {
            if (A[i] > max)
                max = A[i];
        }
        
        int time = 1;
        int tmp = max / 10;
        while ( tmp != 0 ) {
            time ++;
            tmp = tmp/10;
        }

        for ( int i = 1; i < time; i++ ) {

            for( int j = 0; j < bucket.length; j++ ){
                bucket[j] = 0;
            }

            for( int k = 0; k < n; k++ ){
                int num = getTimes(A[k], i);
                bucket[num]++;
            }
            for( int m = 0; m < 9; m++ ){
                bucket[m + 1] = bucket[m] + bucket[m + 1];
            }
            for( int p = n - 1; p >= 0; p-- ){
                int num = getTimes(A[p], i);
                res[ bucket[num] - 1 ] = A[p];
                bucket[num]--;
            }
            for( int q = 0; q < n; q++ ){
                A[q] = res[q];
            }
        }
        return A;
    }
    public static int getTimes(int x, int k){
        int times = (int)Math.pow(10, k);
        return x / times % 10;
    }
}