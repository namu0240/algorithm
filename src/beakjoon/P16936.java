package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16936 {

    static int n;
    static long[] numbers;
    static long[] sortedNumbers;
    static long[] sequence;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new long[n];
        sequence = new long[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);

        for (int i = 0; i < n; i++) {
            solution(0, numbers[i]);
        }

    }

    public static void solution(int index, long number) {

        // 연산을 다 하였다면
        if (index == n) {

            // 만들어진 수열을 비교하기 위해 복사 후 정렬
            long[] cSequence = sequence.clone();
            Arrays.sort(cSequence);

            // 처음에 제공된 수와 만들어진 수열의 수의 값이 모두 동일하다면
            if (Arrays.equals(cSequence, sortedNumbers)) {

                // 출력
                StringBuilder stringBuilder = new StringBuilder();
                for (long l : sequence) {
                    stringBuilder.append(l).append(" ");
                }
                System.out.println(stringBuilder.toString());

                // 답은 1개만 출력하면 됨으로 프로그램 종료
                System.exit(0);
            }
            return;
        }

        sequence[index] = number;

        if (number % 3 == 0) {
            solution(index + 1, number / 3);
        }

        solution(index + 1, number * 2);

    }

}
