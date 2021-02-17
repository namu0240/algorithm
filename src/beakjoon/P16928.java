package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {

    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int[] map;
    static boolean[] visible;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[101];
        visible = new boolean[101];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            map[from] = to;
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            map[from] = to;
        }

        solution();

        System.out.println(answer);

    }

    public static void solution() {

        // 큐를 하나 생성 한 뒤 처음 시작포인트를 기점으로 출발
        Queue<Point> queue = new LinkedList<>();
        Point startPoint = new Point(0, 1);
        queue.add(startPoint);
        visible[1] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            // 도착지에 도착 했다면 움직인 횟수를 계산
            if (point.currentPosition == 100) {
                if (point.moveCount < answer) {
                    answer = point.moveCount;
                }
            }

            // 주사위를 움직임
            for (int i = 1; i <= 6; i++) {

                // 현재 말의 위치에서 주사위의 눈금만큼 움직인 위치를 계산
                int movedPosition = point.currentPosition + i;

                // 위의 말이 도착지를 벗어 났다면 컨티뉴
                if (movedPosition > 100) {
                    continue;
                }

                // 위의 말이 이미 방문한 위치로 이동했다면 컨티뉴
                if (visible[movedPosition]) {
                    continue;
                }

                // 위의 조건이 모두 해당되지 않는다면 방문
                visible[movedPosition] = true;

                // 만약 해당 위치에 이동가능한 블럭이 있다면
                if (map[movedPosition] != 0) {
                    movedPosition = map[movedPosition];
                    visible[movedPosition] = true;
                }

                queue.add(new Point(point.moveCount + 1, movedPosition));
            }
        }

    }

    static class Point {
        int moveCount;
        int currentPosition;

        public Point(int moveCount, int currentPosition) {
            this.moveCount = moveCount;
            this.currentPosition = currentPosition;
        }
    }

}
