package beakjoon.week_6;

import java.util.*;
import java.io.*;

public class P1080 {

    static int n, m;
    static int[][] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = row.charAt(j) - '0';

            }
        }
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = row.charAt(j) - '0';

            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    if (flip(i, j)) {
                        cnt++;
                    } else {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);

    }

    public static boolean flip(int startA, int startB) {

        if (startA + 3 > n || startB + 3 > m) return false;

        for (int i = startA; i <= startA + 2; i++) {
            for (int j = startB; j <= startB + 2; j++) {
                a[i][j] = 1 - (a[i][j]);
            }
        }

        return true;
    }

}