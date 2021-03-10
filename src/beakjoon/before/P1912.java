package beakjoon.before;

import java.util.Arrays;
import java.util.Scanner;

public class P1912 {

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
        int answer = 0;

        dp[0] = arr[0];

        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

}
