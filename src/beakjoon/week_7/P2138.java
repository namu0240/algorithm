package beakjoon.week_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2138 {

    public static char[] input, target;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        backtracking(1, 0);

        input[0] ^= 1;
        input[1] ^= 1;
        backtracking(1, 1);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void backtracking(int idx, int cnt) {
        if (idx == input.length - 1) {
            if (input[idx] == target[idx] && input[idx - 1] == target[idx - 1]) {
                ans = Math.min(ans, cnt);
                return;
            }
            if ((input[idx] ^ 1) == target[idx] && (input[idx - 1] ^ 1) == target[idx - 1]) {
                ans = Math.min(ans, cnt + 1);
            }
            return;
        }
        if (input[idx - 1] == target[idx - 1])
            backtracking(idx + 1, cnt);
        else {
            input[idx] ^= 1;
            input[idx - 1] ^= 1;
            input[idx + 1] ^= 1;
            backtracking(idx + 1, cnt + 1);
            input[idx] ^= 1;
            input[idx - 1] ^= 1;
            input[idx + 1] ^= 1;
        }
    }
}
