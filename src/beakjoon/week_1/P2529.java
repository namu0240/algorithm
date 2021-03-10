package beakjoon.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2529 {

    // comparator count
    private static int k;
    // comparator list
    private static String[] inputs;
    // already used check array
    private static boolean[] visit;
    // first value is minimum, last value is maximum
    private static List<String> resultList;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        k = Integer.parseInt(stringTokenizer.nextToken());
        inputs = new String[k];
        visit = new boolean[10];
        resultList = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            inputs[i] = stringTokenizer.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            solution(i, i + "");
        }

        System.out.println(resultList.get(resultList.size() - 1));
        System.out.println(resultList.get(0));

    }

    public static void solution(int value, String result) {
        if (result.length() == k + 1) {
            resultList.add(result);
        } else {
            for (int i = 0; i < 10; i++) {
                if (visit[i]) {
                    continue;
                }

                if (inputs[result.length() - 1].equals("<")) {
                    if (value >= i) {
                        continue;
                    }
                } else {
                    if (value <= i) {
                        continue;
                    }
                }

                visit[i] = true;
                solution(i, result + i);
            }
        }
        visit[value] = false;
    }

}
