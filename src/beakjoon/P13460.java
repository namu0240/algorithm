package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13460 {

    static int n;
    static int m;
    static char[][] map;
    static int min = Integer.MAX_VALUE;

    static int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    static class Ball {
        int color;
        int y, x;

        public Ball(int y, int x, int color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        String temp;
        Ball r = null, b = null;
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'R') {
                    r = new Ball(i, j, 0);
                    map[i][j] = '.';
                }
                if (map[i][j] == 'B') {
                    b = new Ball(i, j, 1);
                    map[i][j] = '.';
                }
            }
        }

        solution(r, b, 0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    // red, blue를 4방향으로 한 번씩 이동시킨다.
    public static void solution(Ball red, Ball blue, int index) {

        // 10회 이상 움직이면 fail
        if (index >= 10)
            return;

        Ball first, second, temp;
        int ny, nx;

        for (int dir = 0; dir < 4; dir++) {

            first = new Ball(red.y, red.x, red.color);
            second = new Ball(blue.y, blue.x, blue.color);
            // 누가 first? second? 
            if (dir == 0 && first.y > second.y) { // up 이동
                temp = first;
                first = second;
                second = temp;
            } else if (dir == 1 && second.x > first.x) {
                temp = first;
                first = second;
                second = temp;
            } else if (dir == 2 && first.y < second.y) {
                temp = first;
                first = second;
                second = temp;
            } else if (dir == 3 && second.x < first.x) {
                temp = first;
                first = second;
                second = temp;
            }

            // first부터 이동 
            ny = first.y + direction[dir][0];
            nx = first.x + direction[dir][1];
            while (map[ny][nx] == '.') {
                ny += direction[dir][0];
                nx += direction[dir][1];
            }

            boolean isGoal = false;
            if (map[ny][nx] == 'O') {
                if (first.color == 1) {
                    continue;
                } else {
                    isGoal = true;
                }
            } else {
                int rev = (dir == 0 || dir == 2) ? 2 - dir : 4 - dir;
                ny += direction[rev][0];
                nx += direction[rev][1];
                if (ny == second.y && nx == second.x) {
                    ny += direction[rev][0];
                    nx += direction[rev][1];
                }
                first.y = ny;
                first.x = nx;
            }

            // second 이동 
            ny = second.y + direction[dir][0];
            nx = second.x + direction[dir][1];
            while (map[ny][nx] == '.') {
                ny += direction[dir][0];
                nx += direction[dir][1];
            }
            if (map[ny][nx] == 'O') {
                if (second.color == 1)
                    continue;
                else {
                    isGoal = true;
                }
            } else {
                int rev = (dir == 0 || dir == 2) ? 2 - dir : 4 - dir;
                ny += direction[rev][0];
                nx += direction[rev][1];
                if (ny == first.y && nx == first.x) {
                    ny += direction[rev][0];
                    nx += direction[rev][1];
                }
                second.y = ny;
                second.x = nx;
            }

            if (isGoal) {
                if (min > index + 1) {
                    min = index + 1;
                }
                continue;
            }

            if (first.color == 0 && index < 10) {
                solution(first, second, index + 1);
            } else {
                solution(second, first, index + 1);
            }
        }

    }
}
 