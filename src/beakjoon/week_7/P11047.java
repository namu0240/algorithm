package beakjoon.week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;

        int[] money = new int[a];

        for (int i = 0; i < a; i++) {
            money[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int index = money.length - 1;

        while (b != 0) {
            if (money[index] <= b) {
                b -= money[index];
                count++;
                continue;
            }
            index--;
        }

        System.out.println(count);

    }

}
