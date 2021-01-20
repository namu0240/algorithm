package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4574 {

    // 스도쿠 문제랑 비슷한듯..?

    static int cnt;
    static int[][] map;
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int index = 1;

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            cnt = Integer.parseInt(stringTokenizer.nextToken());
            map = new int[9][9];
            isFind = false;

            if (cnt == 0) {
                return;
            }

            for (int i = 0; i < cnt; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                for (int j = 0; j < 2; j++) {
                    int value = Integer.parseInt(stringTokenizer.nextToken());
                    char[] locations = stringTokenizer.nextToken().toCharArray();
                    int row = locations[0] - 'A';
                    int column = locations[1] - '1';
                    map[row][column] = value;
                }
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            for (int i = 1; i < 10; i++) {
                char[] locations = stringTokenizer.nextToken().toCharArray();
                int row = locations[0] - 'A';
                int column = locations[1] - '1';
                map[row][column] = i;
            }

            System.out.println("Puzzle " + index++);
            solution(0, 0);
        }
    }

    public static void solution(int row, int column) {

        // 컬럼이 9인 경우 로우 + 1, 0 부터 다시 시작
        if (column == 9) {
            solution(row + 1, 0);
            return;
        }

        // 로우가 9인 경우 출력 후 프로그램 종료
        if (row == 9) {
            if (!isFind) {
                printMap();
                isFind = true;
            }
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
                stringBuilder.append(anInt);
            }
            stringBuilder.append('\n');
        }
        System.out.print(stringBuilder.toString());
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