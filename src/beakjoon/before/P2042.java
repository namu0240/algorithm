package beakjoon.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        long[] arr = new long[n + 1];
        long[] tree = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine().trim());
            update(tree, i, arr[i]);
        }

        int total = m + k;

        for (int i = 0; i < total; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
            int operator = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if (operator == 1) { // update
                long diff = c - arr[b];
                arr[b] = c;
                update(tree, b, diff);
            } else { // sum
                System.out.println(sum(tree, c) - sum(tree, b - 1));
            }
        }

    }

    public static void update(long[] tree, int i, long diff) {
        while (i < tree.length) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    public static long sum(long[] tree, int i) {
        long result = 0;
        while (i > 0) {
            result += tree[i];
            i -= (i & -i);
        }
        return result;
    }

}

