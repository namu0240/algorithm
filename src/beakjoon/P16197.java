package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16197 {

    static int min = Integer.MAX_VALUE;
    static int width;
    static int height;
    static char[][] map;
    static boolean[][] visible;

    static int[] mx = {0, 0, -1, 1};
    static int[] my = {1, -1, 0, 0};

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

        // 10번 보다 많이 눌러야 한다면 return
        if (index > 10 || index > min) {
            return;
        }

        visible[firstY][firstX] = true;

        for (int i = 0; i < 4; i++) {

            int firstMx = firstX + mx[i];
            int firstMy = firstY + my[i];
            int secondMx = secondX + mx[i];
            int secondMy = secondY + my[i];

            boolean isFirstDrop = isDrop(firstMx, firstMy);
            boolean isSecondDrop = isDrop(secondMx, secondMy);

            if (isFirstDrop && isSecondDrop) {
                continue;
            }

            if (isFirstDrop || isSecondDrop) {
                min = Math.min(min, index + 1);
                continue;
            }

            if (isWall(firstMx, firstMy)) {
                firstMx = firstX;
                firstMy = firstY;
            }

            if (isWall(secondMx, secondMy)) {
                secondMx = secondX;
                secondMy = secondY;
            }

            solution(index + 1, firstMx, firstMy, secondMx, secondMy);
        }

        visible[firstY][firstX] = false;

    }

    public static boolean isDrop(int x, int y) {
        return x < 0 || x >= width || y < 0 || y >= height;
    }

    public static boolean isWall(int x, int y) {
        return map[y][x] == '#';
    }

}
