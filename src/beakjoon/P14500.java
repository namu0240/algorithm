package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {

    static int map[][];
    static int x, y;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();
        StringTokenizer st = new StringTokenizer(p, " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[x + 6][y + 6];
        for (int i = 3; i < y + 3; i++) {
            p = br.readLine();
            st = new StringTokenizer(p, " ");
            for (int j = 3; j < x + 3; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < x + 3; j++) {
            for (int i = 0; i < y + 3; i++) {
                solution(j, i);
            }
        }
        System.out.println(max);
    }

    static void solution(int a, int b) {
        int sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a + 2][b];
        sum += map[a + 3][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a][b + 1];
        sum += map[a][b + 2];
        sum += map[a][b + 3];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a + 1][b + 1];
        sum += map[a][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a + 2][b];
        sum += map[a + 2][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b + 1];
        sum += map[a + 1][b + 1];
        sum += map[a + 2][b + 1];
        sum += map[a + 2][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a][b + 1];
        sum += map[a][b + 2];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b + 2];
        sum += map[a][b + 1];
        sum += map[a][b + 2];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a][b + 1];
        sum += map[a + 1][b + 1];
        sum += map[a + 2][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a][b + 1];
        sum += map[a + 1][b];
        sum += map[a + 2][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b + 2];
        sum += map[a + 1][b + 2];
        sum += map[a + 1][b + 1];
        sum += map[a + 1][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a + 1][b + 2];
        sum += map[a + 1][b + 1];
        sum += map[a + 1][b];
        sum += map[a][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a + 1][b + 1];
        sum += map[a + 2][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b + 2];
        sum += map[a][b + 1];
        sum += map[a + 1][b + 1];
        sum += map[a + 1][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a + 2][b];
        sum += map[a + 1][b];
        sum += map[a + 1][b + 1];
        sum += map[a][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a][b + 1];
        sum += map[a + 1][b + 1];
        sum += map[a + 1][b + 2];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a][b + 1];
        sum += map[a][b + 2];
        sum += map[a + 1][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b + 1];
        sum += map[a + 1][b + 1];
        sum += map[a + 2][b + 1];
        sum += map[a + 1][b];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a + 1][b];
        sum += map[a + 1][b + 1];
        sum += map[a + 1][b + 2];
        sum += map[a][b + 1];
        if (max < sum) {
            max = sum;
        }
        sum = 0;
        sum += map[a][b];
        sum += map[a + 1][b];
        sum += map[a + 2][b];
        sum += map[a + 1][b + 1];
        if (max < sum) {
            max = sum;
        }
    }
}