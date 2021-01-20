package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987 {

    static int rowLength;
    static int columnLength;
    static char[][] map;
    static boolean[] isUseAlphabet = new boolean[26];
    static int[] moveRow = {0, 0, -1, 1};
    static int[] moveCol = {1, -1, 0, 0};
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        rowLength = Integer.parseInt(stringTokenizer.nextToken());
        columnLength = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        solution(1, 0, 0);

        System.out.println(max);
    }

    public static void solution(int index, int row, int column) {

        if (row < 0 || row >= rowLength || column < 0 || column >= columnLength) {
            return;
        }

        int alphabetIndex = map[row][column] - 'A';

        if (isUseAlphabet[alphabetIndex]) {
            return;
        }

        max = Math.max(max, index);

        isUseAlphabet[alphabetIndex] = true;

        for (int i = 0; i < 4; i++) {
            solution(index + 1, row + moveRow[i], column + moveCol[i]);
        }

        isUseAlphabet[alphabetIndex] = false;

    }

}
