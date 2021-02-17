package beakjoon;

import com.sun.codemodel.internal.JCommentPart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9019 {

    static int n;
    static String[] history;
    static boolean[] visited;

    // Q? 커맨드를 어떻게 저장을 할 건인가
    // 현재 수를 기점으로 특정 수가 되었을떄 사용된 커맨드?

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            history = new String[10000];
            visited = new boolean[10000];
            solution(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }

    }

    public static void solution(int startNumber, int findValue) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNumber);

        visited[startNumber] = true;
        Arrays.fill(history, "");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int D = (2 * now) % 10000;
            int S = (now == 0) ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                history[D] = history[now] + "D";
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                history[S] = history[now] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                history[L] = history[now] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                history[R] = history[now] + "R";
            }
        }

        System.out.println(history[findValue]);
    }


}
