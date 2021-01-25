package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P1062 {

    static int bitMask = 0;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader stringBufferedReader = new BufferedReader(new StringReader("" +
                "9 8\n" +
                "antabtica\n" +
                "antaxtica\n" +
                "antadtica\n" +
                "antaetica\n" +
                "antaftica\n" +
                "antagtica\n" +
                "antahtica\n" +
                "antajtica\n" +
                "antaktica"));

        StringTokenizer stringTokenizer = new StringTokenizer(stringBufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 마스킹 처리
            for (char aChar : stringBufferedReader.readLine().toCharArray()) {
                bitMask = bitMask | (1 << aChar - 'a' + 1);
            }
            // 마스킹 개수 처리
            int count = 0;
            for (int j = 1; j < 30; j++) {
                if ((bitMask & (1 << j)) >= 1) {
                    count++;
                }
            }
            // 결과값 처리
            if (count <= k) {
                result++;
            }
            bitMask = 0;
        }
        System.out.println(result);

    }

}
