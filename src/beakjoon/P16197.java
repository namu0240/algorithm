package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16197 {

    static int min = Integer.MAX_VALUE;
    static int width;
    static int height;
    static char[][] map;

    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[height][width];

        boolean isFind = true;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < height; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'o') {
                    if (isFind) {
                        x1 = j;
                        y1 = i;
                        isFind = false;
                    } else {
                        x2 = j;
                        y2 = i;
                    }
                }
            }
        }

        solution(0, x1, y1, x2, y2);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);

    }

    public static void solution(int index, int x1, int y1, int x2, int y2) {

        // 10번 보다 많이 눌러야 한다면 return
        if (index > 10 || index > min) {
            return;
        }

        for (int i = 0; i < 4; i++) {

            int movedX1 = x1 + moveX[i];
            int movedY1 = y1 + moveY[i];
            int movedX2 = x2 + moveX[i];
            int movedY2 = y2 + moveY[i];

            boolean isDropFirstDot = isDrop(movedX1, movedY1);
            boolean isDropSecondDot = isDrop(movedX2, movedY2);

            // 만약 둘다 떨어졌다면 아웃!
            if (isDropFirstDot && isDropSecondDot) {
                continue;
            }

            // 한쪽만 떨어졌다면 index 계산
            if (isDropFirstDot || isDropSecondDot) {
                min = Math.min(min, ((index + 1) > 10) ? Integer.MAX_VALUE : (index + 1));
                continue;
            }

            // 만약 벽이라면 이동을 취소
            if (isWall(movedX1, movedY1)) {
                movedX1 = x1;
                movedY1 = y1;
            }

            // 만약 벽이 아니라면 이동을 취소
            if (isWall(movedX2, movedY2)) {
                movedX2 = x2;
                movedY2 = y2;
            }

            solution(index + 1, movedX1, movedY1, movedX2, movedY2);
        }

    }

    public static boolean isDrop(int x, int y) {
        return x < 0 || x >= width || y < 0 || y >= height;
    }

    public static boolean isWall(int x, int y) {
        return map[y][x] == '#';
    }

}
