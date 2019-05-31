package algorithm.recursion_and_loop;

public class JumpFloorDemo {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(JumpFloor2(n));
    }

    public static int JumpFloor(int target) {
        int first = 1, second = 2;
        int tmp = 0;

        if (target == 1)
            return 1;

        if (target == 2)
            return 2;

        while ( target > 2 ) {
            tmp = first + second;
            first = second;
            second = tmp;
            target--;
        }

        return tmp;
    }

    public static int JumpFloor2(int target) {
        //return (int)Math.pow(2, target-1);
        return 1<<(target-1);
    }

    public int JumpFloorII(int target) {
        if(target == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= target; i++) {
            dp[i] = 0;
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }
}
