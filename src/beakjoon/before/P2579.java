package beakjoon.before;

import java.util.Scanner;

public class P2579 {

    static int[] stair;
    static int[] dp;
    static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        stair = new int[300];
        dp = new int[300];

        for (int i = 0; i < n; i++) {
            stair[i] = scanner.nextInt();
        }

        System.out.println(solution());

    }

    public static int solution() {

        dp[0] = stair[0];
        dp[1] = Math.max(stair[0] + stair[1], stair[1]);
        dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        return dp[n - 1];

    }

}
