package algorithm;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] A = {1,2,4,5,9,11};
        int X = 3;
        int res = findNum(A, X);
        int res2 = binarySearch(A, X, 0, A.length - 1);
       // System.out.println(res2);
        String s3 = "aaa";
        String s = new String(s3);
        String s1 = new String("aaa");
        String s2 = "aaa";
        float f = (float)2.1;
        short r = 1;
        r = (short)(r + 1);
        System.out.println(r);
    }

    private static int findNum(int[] a, int x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < x)
                low = mid + 1;
            else if (a[mid] > x)
                high = mid - 1;
            else return mid;
        }
        return -1;
    }


    public static int binarySearch(int[] a, int x, int start, int end) {
        if (start == end)
            return -1;
        int center = (start + end)/2;
        if ( a[center] > x) {
            return binarySearch(a, x, start, center);
        } else if ( a[center] < x ) {
            return binarySearch(a, x, center + 1, end);
        } else if ( a[center] == x)
            return center;
        return -1;
    }

    public static long gcd( long m, long n ) {
        while ( n != 0 ) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static long pow( long x, int n ) {
        if ( n == 0 )
            return 1;
        if ( n % 2 == 0) {
            return pow( x * x , n / 2 );
        } else return pow( x * x, n / 2 ) * x;
    }
}
