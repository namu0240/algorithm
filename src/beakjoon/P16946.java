package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16946 {

    static final int FIELD = '0';
    static final int WALL = '1';

    static int width, height;
    static char[][] map;
    static int[][] groups;
    static int[] groupSizeArr;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bufferedReader = new BufferedReader(new StringReader("" +
//                "4 5\n" +
//                "11001\n" +
//                "00111\n" +
//                "01010\n" +
//                "10101"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[height][width];
        groups = new int[height][width];
        groupSizeArr = new int[height * width];

        for (int row = 0; row < height; row++) {
            map[row] = bufferedReader.readLine().toCharArray();
        }

        // 필드 그루핑
        int groupIndex = 1;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (map[row][col] == WALL || groups[row][col] != 0) {
                    continue;
                }
                groupField(row, col, groupIndex);
                groupIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                sb.append(countBlock(row,col));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int countBlock(int row, int col) {
        if (map[row][col] == FIELD) return 0;
        else {
            Set<Integer> set = new HashSet<>();
            for (int k = 0; k < 4; k++) {
                int moveRow = row + move[k][0];
                int moveCol = col + move[k][1];
                if (moveRow >= 0 && moveRow < height && moveCol >= 0 && moveCol < width && groups[moveRow][moveCol] != 0) {
                    set.add(groups[moveRow][moveCol]);
                }
            }
            int cnt = 1;
            for (int idx : set) {
                cnt += groupSizeArr[idx];
            }
            return cnt % 10;
        }
    }

    public static void groupField(int row, int col, int index) {
        Queue<Location> locationQueue = new LinkedList<>();
        locationQueue.add(new Location(row, col));
        groups[row][col] = index;
        int groupSize = 1;

        while (!locationQueue.isEmpty()) {

            Location location = locationQueue.poll();

            for (int i = 0; i < 4; i++) {

                int mRow = location.row + move[i][0];
                int mCol = location.col + move[i][1];

                if (mRow < 0 || mRow >= height || mCol < 0 || mCol >= width) {
                    continue;
                }

                if (groups[mRow][mCol] != 0 || map[mRow][mCol] == WALL) {
                    continue;
                }

                locationQueue.add(new Location(mRow, mCol));
                groups[mRow][mCol] = index;
                groupSize++;
            }
        }

        groupSizeArr[index] = groupSize;
    }

    static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }


}