package beakjoon.week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {

    static final int BLANK = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    static int width, height;
    static int[][] map;
    static int result = 0;

    static int[][] move = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        makeWall(0);

        System.out.println(result);
    }

    public static void makeWall(int depth) {

        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if (map[row][col] == BLANK) {
                    map[row][col] = WALL;
                    makeWall(depth + 1);
                    map[row][col] = BLANK;
                }
            }
        }
    }

    public static void spreadVirus() {
        // TODO: 2021/02/17 clone map 
        int[][] virusMap = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                virusMap[row][col] = map[row][col];
            }
        }

        // TODO: 2021/02/17 spread virus
        Queue<Location> locationQueue = new LinkedList<>();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (virusMap[row][col] == VIRUS) {
                    locationQueue.add(new Location(col, row));
                }
            }
        }

        while (!locationQueue.isEmpty()) {
            Location location = locationQueue.poll();

            for (int i = 0; i < 4; i++) {
                int col = location.col + move[i][0];
                int row = location.row + move[i][1];

                if (col < 0 || col >= width || row < 0 || row >= height) {
                    continue;
                }

                if (virusMap[row][col] != BLANK) {
                    continue;
                }

                virusMap[row][col] = VIRUS;
                locationQueue.add(new Location(col, row));
            }
        }

        getSafetyZoneCount(virusMap);
    }

    public static void getSafetyZoneCount(int[][] virusMap) {
        int safetyZoneCount = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (virusMap[row][col] == BLANK) {
                    safetyZoneCount++;
                }
            }
        }

        result = Math.max(result, safetyZoneCount);
    }

}

class Location {
    int row;
    int col;

    public Location(int col, int row) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "row=" + col +
                ", col=" + row +
                '}';
    }
}
