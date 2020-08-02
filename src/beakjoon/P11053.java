package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P11053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int size = arr.length;
        int[] dp = new int[size];
        int ans = 0;

        for (int i = 0; i < size; i++) {

            dp[i] = 1;

            // 값의 처음부터 순회를 함.
            for (int j = 0; j < i; j++) {

                // 자기보다 작으면 1씩 증가함.
                // arr[i] > arr[j] 현재의 값이 현재 순회하고 있는 값보다 크고,
                // dp[j] + 1 > dp[i] 현재 순회하고 있는 값의 누적치에 1을 더한 값이 현재의 값의 누적치 보다 크다면 ( 최대값 갱신? )
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;

                System.out.println(Arrays.toString(dp));
            }

        }

        for (int i = 0; i < size; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
