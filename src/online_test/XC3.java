package online_test;
import java.util.Scanner;


public class XC3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mx = 0;
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            mx = Math.max(arr[i], mx);
        }
        int l = mx, r = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (resolve(arr, mid, m, n) != 0) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        System.out.println(ans);
    }

    static int resolve(int[] arr, int mid, int m, int n) {
        int alrea = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + arr[i] > mid) {
                alrea++;
                sum = arr[i];
            } else
                sum += arr[i];
            if (alrea > m) return 0;
        }
        return 1;
    }
}