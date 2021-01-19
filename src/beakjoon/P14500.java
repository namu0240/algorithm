package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {

    static int n;
    static int m;
    static int[][] field;
    static int max;
    static boolean[][][] tetrominos = new boolean[][][]{
            { // ----
                    {true, true, true, true}
            },
            { // ㅁ
                    {true, true},
                    {true, true}
            },
            { // ㄴ
                    {true},
                    {true},
                    {true},
                    {true, true}
            },
            { // ㄴㄱ
                    {true},
                    {true, true},
                    {false, true}
            },
            { // ㅜ
                    {true, true, true},
                    {false, true, false}
            },
    };

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        field = new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                field[n][m] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        solution();

    }

    private static void solution() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (boolean[][] tetromino : tetrominos) {
                    for (int k = 0; k < tetromino.length; k++) {
                        for (int o = 0; o < tetromino[k].length; o++) {

                        }
                    }
                }
            }
        }
    }

}
