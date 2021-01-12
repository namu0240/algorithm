package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {

    static int count;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            count = Integer.parseInt(stringTokenizer.nextToken());
            numbers = new int[count];

            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            if (count == 0) {
                return;
            }

            recursive(0, 0, "");
            System.out.println();
        }
    }

    public static void recursive(int depth, int index, String result) {

        // 만약 번호 6개를 다 뽑았다면 정지
        if (depth == 6) {
            System.out.println(result);
            return;
        }

        for (int i = index; i < count; i++) {
            recursive(depth + 1, i + 1, result + numbers[i] + ((depth + 1) == 6 ? "" : " "));
        }

    }

}
