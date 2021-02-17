package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16922 {

    static int n;
    static boolean[] number;
    static int[] lomaNumber = {1, 5, 10, 50};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        number = new boolean[n * 50 + 1];

        solution(0, 0, 0);

        System.out.println(result);
    }

    public static void solution(int index, int forI, int sum) {
        System.out.println("index = " + index + ", forI = " + forI + ", sum = " + sum);

        if (index == n) {
            if (!number[sum]) {
                number[sum] = true;
                result++;
            }
            return;
        }

        for (int i = forI; i < 4; i++) {
            solution(index + 1, i, sum + lomaNumber[i]);
        }
    }

}
