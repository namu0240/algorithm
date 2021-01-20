package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2580 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        solution(0, 0);
    }

    public static void solution(int row, int column) {

        // 컬럼이 9인 경우 로우 + 1, 0 부터 다시 시작
        if (column == 9) {
            solution(row + 1, 0);
            return;
        }

        // 로우가 9인 경우 출력 후 프로그램 종료
        if (row == 9) {
            printMap();
            System.exit(0);
            return;
        }

        // 만약 해당 위치의 값이 0이라면 숫자 찾기
        if (map[row][column] == 0) {
            for (int i = 1; i < 10; i++) {
                if (!isPossibility(row, column, i)) {
                    continue;
                }

                map[row][column] = i;
                solution(row, column + 1);
            }
            map[row][column] = 0;
            return;
        }

        // 다음 칸 진행
        solution(row, column + 1);
    }

    public static void printMap() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : map) {
            for (int anInt : ints) {
                stringBuilder.append(anInt).append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }

    public static boolean isPossibility(int row, int column, int value) {

        // vertical
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        // horizon
        for (int i = 0; i < 9; i++) {
            if (map[i][column] == value) {
                return false;
            }
        }

        // square
        int startRow = row / 3 * 3; // if 1..2 = 0, 3..5 = 1 6..8 = 2;
        int startColumn = column / 3 * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}