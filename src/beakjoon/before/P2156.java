package beakjoon.before;

import java.util.Scanner;

public class P2156 {

    /**
     * [ Comment ]
     *
     * 와인을 3번 연속으로 먹을 수 없다. 라는 것은 아래 3가지 조건은 가능하다는 소리.
     *
     * 0번 연속으로 먹는 경우
     *  dp[i-1]
     * 1번 연속으로 먹는 경우
     *  dp[i-2] + array[i]
     * 2번 연속으로 먹는 경우
     *  dp[i-3] + array[i-1] + array[i]
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] arr = new int[t + 1];

        for (int i = 1; i <= t; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(t, arr));

    }

    public static int solution(int t, int[] arr) {

        int[] dp = new int[t + 1];

        dp[1] = arr[1];

        if (t > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= t; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        return dp[t];

    }

}
