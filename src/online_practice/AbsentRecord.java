package online_practice;

/*
    给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
    'A' : Absent，缺勤
    'P' : Present，到场
    如果一个员工的考勤纪录中不超过两个 'A'(缺勤), 那么这个员工会被奖赏。

    如果你作为一个员工，想在连续 N 天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求
 */

import java.util.Scanner;

public class AbsentRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Cn^2+Cn^1+Cn^0
        System.out.println(1 + n + n * (n - 1) / 2);
    }

}
