package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16917 {

    static int a; // 양념 가격
    static int b; // 후라이드 가격
    static int c; // 반반 가격
    static int x; // 양념 치킨 구매 개수
    static int y; // 후라이드 치킨 구매 개수

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());

        long result = 0;

        // 만약 반반으로 2개 한 가격이 단일 제품으로 구매한 가격보다 싸다면
        if (a + b >= c * 2) {
            // 양념을 훌아이드 보다 많이 구매해야 한다면
            if (x >= y) {
                // 2 * 반반마리 개수 * 양념 마리 수 + 양념 가격 * ( 양념 마리 수 - 후라이드 마리 수 )
                result += 2 * c * y + a * (x - y);
            } else {
                // 2 * 반반마리 개수 * 후라이드 마리 수 + 후라이드 가격 * ( 후라이드 마리 수 - 양념 마리 수 )
                result += 2 * c * x + b * (y - x);
            }
        } else {
            // 양념 마리 수 * 양념 가격 + 후라이드 마리 수 * 후라이드 가격
            result += a * x + b * y;
        }

        long temp = 0;

        if (x >= y) {
            temp += 2 * c * x;
        } else {
            temp += 2 * c * y;
        }

        System.out.println(Math.min(result, temp));
    }

}
