package beakjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {

    static int count;
    static int[] requireDay;
    static int[] priceTable;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bufferedReader.readLine());
        requireDay = new int[count];
        priceTable = new int[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            requireDay[i] = Integer.parseInt(stringTokenizer.nextToken());
            priceTable[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < count; i++) {
            solution(i, 0);
        }

        System.out.println(max);
    }

    public static void solution(int index, int price) {

        if (index >= count) {
            max = Math.max(max, price);
            return;
        }

        // 오늘 날짜를 선택 하였을 경우
        if (index + requireDay[index] <= count) {
            solution(index + requireDay[index], price + priceTable[index]);
        }

        // 오늘 날짜를 선택하지 않았을 경우
        solution(index + 1, price);
    }

}
