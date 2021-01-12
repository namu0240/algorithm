package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {

    static int count;
    static int sequenceSum;
    static int[] numbers;
    static int result;

    public static void main(String[] args) throws IOException {

        /**
         5 0
         -7 -3 -2 5 8
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        count = Integer.parseInt(stringTokenizer.nextToken());
        sequenceSum = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[21];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solution(0, 0);

        System.out.println(result);

    }

    public static void solution(int index, int sum) {

        sum += numbers[index];

        if (index >= count) {
            return;
        }

        if (sum == sequenceSum) {
            result++;
        }

        solution(index + 1, sum - numbers[index]);
        solution(index + 1, sum);

    }

}
