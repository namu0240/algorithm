package beakjoon;

import java.util.Scanner;

public class P2193 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(90));
    }

    static long[] dp = new long[91];

    public static long solution(int n) {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        if (n < 3) {
            return dp[n];
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}