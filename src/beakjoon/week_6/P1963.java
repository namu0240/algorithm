package beakjoon.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P1963 {

    static int T;
    static boolean[] minority = new boolean[10000]; // false 면 소수임
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        T = Integer.parseInt(stringTokenizer.nextToken());

        makePrimeNumber();

        for (int i = 0; i < T; i++) {
            answer = Integer.MAX_VALUE;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int input = Integer.parseInt(stringTokenizer.nextToken());
            int output = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(solution(input, output) == Integer.MAX_VALUE ? "Impossible" : answer);
        }

    }

    public static int solution(int input, int output) {

        boolean[] visited = new boolean[10000];
        visited[input] = true;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(input, 0));

        while (!nodeQueue.isEmpty()) {
            Node p = nodeQueue.poll();

            if (p.number == output) {
                answer = Math.min(answer, p.count);
            }

            for (int i = 0; i <= 9; i++) {
                if (i != p.getFour()) {
                    int next = i * 1000 + p.getThird() * 100 + p.getSecond() * 10 + p.getFirst();
                    if (1000 <= next && !minority[next] && !visited[next]) {
                        visited[next] = true;
                        nodeQueue.add(new Node(next, p.count + 1));
                    }
                }
                if (i != p.getThird()) {
                    int next = p.getFour() * 1000 + i * 100 + p.getSecond() * 10 + p.getFirst();
                    if (1000 <= next && !minority[next] && !visited[next]) {
                        visited[next] = true;
                        nodeQueue.add(new Node(next, p.count + 1));
                    }
                }
                if (i != p.getSecond()) {
                    int next = p.getFour() * 1000 + p.getThird() * 100 + i * 10 + p.getFirst();
                    if (1000 <= next && !minority[next] && !visited[next]) {
                        visited[next] = true;
                        nodeQueue.add(new Node(next, p.count + 1));
                    }
                }
                if (i != p.getFirst()) {
                    int next = p.getFour() * 1000 + p.getThird() * 100 + p.getSecond() * 10 + i;
                    if (1000 <= next && !minority[next] && !visited[next]) {
                        visited[next] = true;
                        nodeQueue.add(new Node(next, p.count + 1));
                    }
                }
            }
        }
        return answer;
    }

    public static void makePrimeNumber() {
        for (int i = 2; i <= 9999; i++) {
            if (!minority[i]) {
                for (int j = 2 * i; j <= 9999; j += i) {
                    minority[j] = true;
                }
            }
        }
    }

    static class Node {
        int number;
        int count;

        public Node(int number, int cnt) {
            this.number = number;
            this.count = cnt;
        }

        public int getFirst() {
            return number % 10;
        }

        public int getSecond() {
            return (number % 100) / 10;
        }

        public int getThird() {
            return (number % 1000) / 100;
        }

        public int getFour() {
            return (number) / 1000;
        }
    }
}