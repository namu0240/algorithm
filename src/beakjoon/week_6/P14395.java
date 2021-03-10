package beakjoon.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14395 {

    static HashSet<Long> longHashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int input = Integer.parseInt(stringTokenizer.nextToken());
        int output = Integer.parseInt(stringTokenizer.nextToken());

        solution(input, output);

    }

    public static void solution(long input, long output) {

        if (input == output) {
            System.out.println(0);
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(input, ""));

        while (!nodeQueue.isEmpty()) {

            Node node = nodeQueue.poll();

            if (node.number == output) {
                System.out.println(node.operator);
                return;
            }

            if (node.number < 1) {
                continue;
            }

            if (longHashSet.contains(node.number)) {
                continue;
            }

            longHashSet.add(node.number);

            try {
                nodeQueue.add(new Node(node.number * node.number, node.operator + "*"));
                nodeQueue.add(new Node(node.number + node.number, node.operator + "+"));
                nodeQueue.add(new Node(0, node.operator + "-"));
                nodeQueue.add(new Node(1, node.operator + "/"));
            } catch (OutOfMemoryError error) {
                System.out.println(-1);
            }

        }

        System.out.println(-1);
    }

    static class Node {
        private long number;
        private String operator;

        public Node(long number, String operator) {
            this.number = number;
            this.operator = operator;
        }
    }

}
