package beakjoon.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {

    static int operatorCount = 0;
    static int n;
    static int[] numbers;
    static int[] operator;

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[n];
        operator = new int[4];

        // parse numbers
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // parse operator count
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stringTokenizer.nextToken());
            operatorCount += operator[i];
        }

        dfs(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int depth, long value) {
        if (numbers.length - 1 == depth) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] == 0) {
                continue;
            }

            operator[i]--;
            ++depth;

            if (i == 0) {
                dfs(depth, value + numbers[depth]);
            } else if (i == 1) {
                dfs(depth, value - numbers[depth]);
            } else if (i == 2) {
                dfs(depth, value * numbers[depth]);
            } else {
                dfs(depth, value / numbers[depth]);
            }

            operator[i]++;
            depth--;

        }
    }

}
