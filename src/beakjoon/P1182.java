package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {

    static int n;
    static int s;
    static int count;
    static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        System.out.println(count);

    }

    public static void dfs(int index, int depth, int sum) {


        if (sum == s) {
            count++;
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            dfs(i + 1, depth + 1, sum + numbers[i]);
        }

    }

}
