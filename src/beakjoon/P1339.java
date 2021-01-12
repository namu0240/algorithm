package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1339 {

    public static int n;
    public static String[] strings;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = bufferedReader.readLine();
        }

        solution();

    }

    public static void solution() {

        int[] alphabet = new int[26];
        int value = 9;
        int result = 0;

        for (String string : strings) {

            int pos = (int) Math.pow(10, string.length() - 1);
            char[] word = string.toCharArray();

            for (char c : word) {
                alphabet[c - 'A'] += pos;
                pos /= 10;
            }

        }

        Arrays.sort(alphabet);

        for (int i = alphabet.length - 1; i > -1; i--) {
            result += alphabet[i] * value--;
        }

        System.out.println(result);

    }

}
