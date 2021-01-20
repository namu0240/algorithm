package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P9663 {

    static int[] path;
    static int n;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        path = new int[n + 1];

        solution(0);
        System.out.println(ans);
    }

    private static void solution(int col) {

        // 최종까지 왔다면 결과 값을 1 카운트
        if (col == n) {
            ans++;
            return;
        }

        // 다시 다른 경우의 수를 탐색 한다.
        for (int i = 0; i < n; i++) {
            path[col] = i;
            if (isPossible(col)) {
                solution(col + 1);
            }
        }
    }

    public static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 열 상에 있거나 같은 대각선 상에 있다면
            if (path[i] == path[col] || Math.abs(col - i) == Math.abs(path[col] - path[i])) {
                return false;
            }
        }
        return true;
    }

}