package beakjoon.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class P12100 {

    static int n;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new StringReader("" +
                "3\n" +
                "2 2 2\n" +
                "4 4 4\n" +
                "8 8 8"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        solution(0);

        System.out.println(max);
    }

    public static void solution(int index) {
        // break point
        if (index == 5) {
            System.out.println("out!");
            System.out.println(max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            int[][] copyMap = new int[n][n];
            backUpToMap(map, copyMap);
            moveDirectionWithMerge(i);
            solution(index + 1);
            backUpToMap(copyMap, map);
        }
    }

    public static void backUpToMap(int[][] from, int[][] to) {
        for (int i = 0; i < n; i++) {
            System.arraycopy(from[i], 0, to[i], 0, n);
        }
    }

    public static void moveWithMerge(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {

            if (integerList.get(i) == null || integerList.get(i + 1) == null) {
                break;
            }

            // 두개의 수가 다르면 다음 수를 비교
            if (!integerList.get(i).equals(integerList.get(i + 1))) {
                continue;
            }

            int sumValue = integerList.get(i) + integerList.get(i + 1);
            integerList.add(i, sumValue);
            integerList.remove(i + 1);
            integerList.remove(i + 1);
        }
    }

    public static void moveDirectionWithMerge(int direction) {
        List<Integer> integerList = new ArrayList<>();
        switch (direction) {
            case 1: // UP
                for (int col = 0; col < n; col++) {
                    integerList.clear();

                    for (int row = 0; row < n; row++) {
                        if (map[row][col] == 0) {
                            continue;
                        }

                        integerList.add(map[row][col]);
                        map[row][col] = 0;
                    }

                    moveWithMerge(integerList);

                    for (int i = 0; i < integerList.size(); i++) {
                        map[i][col] = integerList.get(i);
                    }
                }
                break;
            case 2: // DOWN
                for (int col = 0; col < n; col++) {
                    integerList.clear();

                    for (int row = n - 1; row >= 0; row--) {
                        if (map[row][col] == 0) {
                            continue;
                        }

                        integerList.add(map[row][col]);
                        map[row][col] = 0;
                    }

                    moveWithMerge(integerList);

                    for (int i = 0; i < integerList.size(); i++) {
                        map[n - 1 - i][col] = integerList.get(i);
                    }
                }
                break;
            case 3: // LEFT
                for (int row = 0; row < n; row++) {
                    integerList.clear();

                    for (int col = 0; col < n; col++) {
                        if (map[row][col] == 0) {
                            continue;
                        }

                        integerList.add(map[row][col]);
                        map[row][col] = 0;
                    }

                    moveWithMerge(integerList);

                    for (int i = 0; i < integerList.size(); i++) {
                        map[i][row] = integerList.get(i);
                    }
                }
                break;
            case 4: // RIGHT
                for (int row = 0; row < n; row++) {
                    integerList.clear();

                    for (int col = n - 1; col >= 0; col--) {
                        if (map[row][col] == 0) {
                            continue;
                        }

                        integerList.add(map[row][col]);
                        map[row][col] = 0;
                    }

                    moveWithMerge(integerList);

                    for (int i = 0; i < integerList.size(); i++) {
                        map[n - 1 - i][row] = integerList.get(i);
                    }
                }
                break;
        }
    }

}
