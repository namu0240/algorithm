package beakjoon.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15658 {

    private static int n;
    private static int[] numbers;
    private static int[] operators;

    private static long max = Long.MIN_VALUE;
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[n];
        operators = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solution(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int index, long value) {

        if (index == numbers.length) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }

            operators[i]--;
            switch (i) {
                case 0:
                    solution(index + 1, value + numbers[index]);
                    break;
                case 1:
                    solution(index + 1, value - numbers[index]);
                    break;
                case 2:
                    solution(index + 1, value * numbers[index]);
                    break;
                case 3:
                    solution(index + 1, value / numbers[index]);
                    break;
            }
            operators[i]++;
        }

    }

}
