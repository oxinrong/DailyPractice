package algorithm;

public class MaxSumDemo {
    public static void main(String[] args) {
        int[] A = {1,3,-2,5,-10,2};
        int res = maxSum4(A);

        System.out.println(res);
    }

    public static int maxSum1(int[] A) {
        int maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += A[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSum2( int[] A ) {
        int maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            int thisSum = 0;
            for (int j = i; j < A.length; j++) {
                thisSum += A[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSum3( int[] A ) {
        return maxSumRec(A, 0, A.length-1);
    }

    private static int maxSumRec( int[] a, int left, int right ) {
        if ( left == right)
            if ( a[left] > 0 )
                return a[left];
            else
                return 0;

        int center = ( left + right ) / 2;
        System.out.println(center);
        System.out.println("递归左");
        int maxLeftSum = maxSumRec(a, left, center);
        System.out.println("递归右");
        int maxRightSum = maxSumRec(a, center + 1, right );

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if ( leftBorderSum > maxLeftBorderSum ) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right ; i++) {
            rightBorderSum += a[i];
            if ( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }
        System.out.println("maxleft:" + maxLeftSum + ", maxRight:" + maxRightSum + ", i:" + (maxLeftBorderSum+maxRightBorderSum));
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        int max = 0;
        if (maxLeftSum > max)
            max = maxLeftSum;
        if (maxRightSum > max)
            max  = maxRightSum;
        if (i > max)
            max = i;
        return max;
    }

    public static int maxSum4( int[] a ) {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if ( thisSum < 0 ) {
                thisSum = 0;
            }
            System.out.println(i+","+thisSum);

        }
        return maxSum;
    }
}
