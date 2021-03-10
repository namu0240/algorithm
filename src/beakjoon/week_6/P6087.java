package beakjoon.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6087 {

    static int width, height;
    static char[][] map;
    static boolean[][][] visited;
    static List<Node> nodes = new ArrayList<>();
    static List<Node> goalNodes = new ArrayList<>();
    static int[][] move = {{-1, 1, 0, 0}, {0, 0, -1, 1}};


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        width = Integer.parseInt(stringTokenizer.nextToken());
        height = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[height][width];
        visited = new boolean[4][height][width];

        for (int i = 0; i < height; i++) {
            char[] chars = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'C') {
                    nodes.add(new Node(i, j, 0, 0));
                }
            }
        }

        solution();

        Collections.sort(goalNodes);
        System.out.println(goalNodes.get(0).mirror);

    }

    private static void solution() {

        Queue<Node> nodeQueue = new PriorityQueue<>();
        Node firstNode = nodes.get(0);

        for (int i = 0; i < 4; i++) {
            int row = firstNode.row + move[0][i];
            int col = firstNode.col + move[1][i];
            int mirror = 0;
            int dir = i;

            nodeQueue.add(new Node(row, col, dir, mirror));
        }

        while (!nodeQueue.isEmpty()) {

            // TODO: 2021/03/03 노드 꺼내기
            Node node = nodeQueue.poll();

            // TODO: 2021/03/03 OutOfIndexException
            if (node.row < 0 || node.row >= height || node.col < 0 || node.col >= width) {
                continue;
            }

            // TODO: 2021/03/03 벽을 만났느냐?!?!?!?
            if (map[node.row][node.col] == '*') {
                continue;
            }

            // TODO: 2021/03/03 도착점 체크
            if (node.col == nodes.get(1).col && node.row == nodes.get(1).row) {
                goalNodes.add(node);
                continue;
            }

            // TODO: 2021/03/03 방문 여부 체크
            if (visited[node.dir][node.row][node.col]) {
                continue;
            }

            visited[node.dir][node.row][node.col] = true;

            // TODO: 2021/03/03 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int row = node.row + move[0][i];
                int col = node.col + move[1][i];
                int mirror = node.dir == i ? node.mirror : node.mirror + 1;
                int dir = i;

                Node nextNode = new Node(row, col, dir, mirror);
                nodeQueue.add(nextNode);
            }

        }

    }

    static class Node implements Comparable {
        int row, col, dir, mirror;

        public Node(int row, int col, int dir, int mirror) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", dir=" + dir +
                    ", mirror=" + mirror +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(mirror, ((Node) o).mirror);
        }
    }

}