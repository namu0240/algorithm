package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int count = Integer.parseInt(stringTokenizer.nextToken());
        int optCount = Integer.parseInt(stringTokenizer.nextToken());

        long[] array = new long[count + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= count; i++) {
            array[i] = array[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < optCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(solution(array, from, end));
        }
    }

    public static long solution(long[] array, int start, int end) {
        return array[end] - array[start - 1];
    }

}
