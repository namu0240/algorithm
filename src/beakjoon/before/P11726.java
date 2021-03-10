package beakjoon.before;

import java.util.Scanner;

public class P11726 {

    static int[] dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 2;

//        for (int i = 1; i <= 1000; i++) {
        System.out.println(solution(n));
//        }

    }

    public static int solution(int n) {

        if (n < 3) {
            return dp[n - 1];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return dp[n - 1];
    }

}
