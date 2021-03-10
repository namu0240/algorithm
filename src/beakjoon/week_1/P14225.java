package beakjoon.week_1;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14225 {

    private static int n;
    private static int[] s;
    private static boolean[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        s = new int[n + 1];
        int maxValue = 1;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(stringTokenizer.nextToken());
            maxValue += s[i];
        }

        result = new boolean[maxValue];

        solution(0, 0);

        for (int i = 0; i < result.length; i++) {
            if (!result[i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(result.length);

    }

    public static void solution(int index, int sum) {

        sum += s[index];

        result[sum] = true;

        if (index == n) {
            return;
        }

        solution(index + 1, sum - s[index]);
        solution(index + 1, sum);

    }

}
