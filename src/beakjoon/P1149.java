package beakjoon;

import java.util.Scanner;

public class P1149 {

    static int n;
    static int[][] price;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        price = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                price[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution());

    }

    public static int solution() {

        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }

}
