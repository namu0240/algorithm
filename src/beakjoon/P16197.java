package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16197 {

    /*
6 2
..
..
..
o#
o#
##
     */

    static int min = Integer.MAX_VALUE;
    static int width;
    static int height;
    static char[][] map;
    static boolean[][] visible;

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[height][width];
        visible = new boolean[height][width];

        boolean isFirst = true;
        int firstX = 0;
        int firstY = 0;
        int secondX = 0;
        int secondY = 0;

        for (int i = 0; i < height; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'o') {
                    if (isFirst) {
                        firstX = j;
                        firstY = i;
                        isFirst = false;
                    } else {
                        secondX = j;
                        secondY = i;
                    }
                }
            }
        }

        solution(0, firstX, firstY, secondX, secondY);

        System.out.println(min);

    }

    public static void solution(int index, int firstX, int firstY, int secondX, int secondY) {
        System.out.println("index = " + index + ", firstX = " + firstX + ", firstY = " + firstY + ", secondX = " + secondX + ", secondY = " + secondY);

        for (char[] chars : map) {
            System.out.println(Arrays.toString(chars));
        }

        // 10번 보다 많이 눌러야 한다면 return
        if (index > 10) {
            return;
        }

        boolean isFirstDrop = isDrop(firstX, firstY);
        boolean isSecondDrop = isDrop(secondX, secondY);

        // 만약에 떨어졌다면 재귀 종료
        if (isFirstDrop || isSecondDrop) {

            // 둘다 떨어졌다면 올바르지 않은 조작
            if (isFirstDrop && isSecondDrop) {
                return;
            }

            min = Math.min(min, index);
            return;
        }

        // 만약 이동한 위치의 블럭이 벽이라면 종료
        if (map[firstY][firstX] == '#' || map[secondY][secondX] == '#') {
            return;
        }

        // 이미 방문한 위치라면 종료
        if (visible[firstY][firstX]) {
            return;
        }

        visible[firstY][firstX] = true;

        for (int i = 0; i < 4; i++) {
            solution(index + 1, firstX + mx[i], firstY + my[i], secondX + mx[i], secondY + my[i]);
        }

        visible[firstY][firstX] = false;

    }

    public static boolean isDrop(int x, int y) {
        return x < 0 || x >= width || y < 0 || y >= height;
    }

}
