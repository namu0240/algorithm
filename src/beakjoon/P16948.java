package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16948 {

    static int[][] move = {
            {-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}
    };

    static int n;
    static int targetR;
    static int targetC;
    static boolean[][] visible;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        visible = new boolean[n][n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        Point startPoint = new Point(r, c, 0);

        targetR = Integer.parseInt(stringTokenizer.nextToken());
        targetC = Integer.parseInt(stringTokenizer.nextToken());

        solution(startPoint);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void solution(Point startPoint) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.x == targetR && point.y == targetC) {
                if (point.moveCount < answer) {
                    answer = point.moveCount;
                }
            }

            for (int[] movePos : move) {

                int mx = point.x + movePos[0];
                int my = point.y + movePos[1];

                // 이동이 불가능 한 경우
                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                // 이미 방문 했을 경우
                if (visible[mx][my]) {
                    continue;
                }

                visible[mx][my] = true;
                queue.add(new Point(mx, my, point.moveCount + 1));

            }

        }

    }

    static class Point {
        int x;
        int y;
        int moveCount;

        public Point(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

}
