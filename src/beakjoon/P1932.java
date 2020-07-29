package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1932 {

    static int[][] map = new int[6][6];
    static int[][] dp = new int[6][6];
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution());
    }

    public static int solution() {

        dp[0][0] = map[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int target = dp[i][j];
                dp[i + 1][j] = Math.max(target + map[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(target + map[i + 1][j + 1], dp[i + 1][j + 1]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        return max;
    }

}
