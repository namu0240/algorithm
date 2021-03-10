package beakjoon.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {

    static char[][] map;
    static int r, c;
    static int[][] move = new int[][]{{-1, 0, 1, 0}, {0, -1, 0, 1}};
    static Queue<Node> water = new LinkedList<>();
    static Queue<Node> hedgehog = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = input[j];

                if (input[j] == '*') {
                    water.add(new Node(i, j));
                }

                if (input[j] == 'S') {
                    hedgehog.add(new Node(i, j));
                }
            }
        }

        solution();

    }

    public static void solution() {

        int ans = 0;
        while (true) {
            ++ans;
            if (hedgehog.size() == 0) {
                System.out.println("KAKTUS");
                return;
            }

            extendWater();
            if (extendHedgehog()) {
                System.out.println(ans);
                return;
            }
        }

    }

    public static void extendWater() {

        int waterSize = water.size();

        for (int i = 0; i < waterSize; i++) {

            Node node = water.poll();

            if (node == null) {
                continue;
            }

            for (int j = 0; j < 4; j++) {

                int nx = move[0][j] + node.x;
                int ny = move[1][j] + node.y;

                if (0 > nx || nx >= c || 0 > ny || ny >= r) {
                    continue;
                }

                if (map[ny][nx] == '.') {
                    map[ny][nx] = '*';
                    water.add(new Node(ny, nx));
                }
            }

        }

    }

    public static boolean extendHedgehog() {

        int hedgehogSize = hedgehog.size();

        for (int i = 0; i < hedgehogSize; i++) {

            Node node = hedgehog.poll();

            if (node == null) {
                continue;
            }

            for (int j = 0; j < 4; j++) {

                int nx = move[0][j] + node.x;
                int ny = move[1][j] + node.y;

                if (0 > nx || nx >= c || 0 > ny || ny >= r) {
                    continue;
                }

                if (map[ny][nx] == 'D') {
                    hedgehog.add(new Node(ny, nx));
                    return true;
                }

                if (map[ny][nx] == '.') {
                    map[ny][nx] = 'S';
                    hedgehog.add(new Node(ny, nx));
                }

            }

        }

        return false;
    }

    static class Node {
        int x;
        int y;

        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
