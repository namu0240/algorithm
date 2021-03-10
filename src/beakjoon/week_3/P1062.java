package beakjoon.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1062 {

    static int n;
    static int k;
    static boolean[] visible;
    static String[] strings;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        visible = new boolean[27];
        strings = new String[n];

        if (k < 5) {
            System.out.println(0);
        } else if (k == 26) {
            System.out.println(n);
        } else {
            for (int i = 0; i < n; i++) {
                String string = bufferedReader.readLine();
                strings[i] = string.substring(4, string.length() - 4);
            }
            // 기본 값
            visible[0] = true;
            visible['n' - 'a'] = true;
            visible['t' - 'a'] = true;
            visible['i' - 'a'] = true;
            visible['c' - 'a'] = true;
            k -= 5;

            solution(0, 0);

            System.out.println(max);
        }

    }

    public static void solution(int index, int start) {
        if (index == k) {
            int countWord = 0;
            for (int i = 0; i < n; i++) {
                boolean isReadable = true;
                for (char aChar : strings[i].toCharArray()) {
                    // 읽을 수 없다면
                    if (!visible[aChar - 'a']) {
                        isReadable = false;
                        break;
                    }
                }
                if (isReadable) {
                    countWord++;
                }
            }
            max = Math.max(max, countWord);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visible[i]) {
                visible[i] = true;
                solution(index + 1, i);
                visible[i] = false;
            }
        }
    }

}
