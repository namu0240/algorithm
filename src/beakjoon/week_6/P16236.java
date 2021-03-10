package beakjoon.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16236 {

    final static int EMPTY = 0;
    final static int BABY_SHARK = 9;

    static int n;
    static int[][] map;
    static boolean[][] visible;
    static int[][] move = new int[][]{{-1, 0, 1, 0}, {0, -1, 0, 1}};

    static int sharkLevel = 2;
    static int sharkExp = 0;
    static int sharkEatCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader("" +
                "4\n" +
                "4 3 2 1\n" +
                "0 0 0 0\n" +
                "0 0 9 0\n" +
                "1 2 3 4"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[n][n];
        visible = new boolean[n][n];

        Node startSharkNode = null;

        for (int row = 0; row < n; row++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[row][col] == 9) {
                    map[row][col] = 0;
                    startSharkNode = new Node(row, col, 0);
                }
            }
        }

        solution(startSharkNode);

    }

    public static void solution(Node startSharkNode) {

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(startSharkNode);
        visible[startSharkNode.row][startSharkNode.col] = true;

        while (!nodeQueue.isEmpty()) {

            Node shark = nodeQueue.poll();

            // TODO: 2021/03/02 상어가 이동한닷!
            for (int j = 0; j < 4; j++) {

                int nRow = move[0][j] + shark.row;
                int nCol = move[1][j] + shark.col;

                // TODO: 2021/03/02 앱 밖으로 나갔는지 체크!
                if (0 > nRow || nRow >= n || 0 > nCol || nCol >= n) {
                    continue;
                }

                // TODO: 2021/03/02 방문여부 체크
                if (visible[nRow][nCol]) {
                    continue;
                }

                visible[nRow][nCol] = true;

                // TODO: 2021/03/02 상어 밥을 찾았을 경우
                if (map[nRow][nCol] != 0 && map[nRow][nCol] <= sharkLevel) {
                    System.out.println(String.format("shark eat! [%d]", shark.move));
                    // TODO: 2021/03/02 상어가 밥을 먹고
                    map[nRow][nCol] = 0;
                    sharkExp++;
                    // TODO: 2021/03/02 상어 성장도 체크
                    if (sharkExp == sharkLevel) {
                        sharkLevel++;
                        sharkExp = 0;
                    }
                    // TODO: 2021/03/02 다음 먹이 탐색을 위한 초기화
                    visible = new boolean[n][n];
                    // TODO: 2021/03/02 현재 위치에서 다시 큐를 돌려!
                    nodeQueue.add(new Node(nCol, nRow, shark.move + 1));
                    break;
                }

                // TODO: 2021/03/02 상어 밥을 찾지 못했을 경우 
                nodeQueue.add(new Node(nCol, nRow, shark.move + 1));
            }

        }

    }

    static class Node {
        int row, col;
        int move;

        public Node(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", move=" + move +
                    '}';
        }
    }

}
