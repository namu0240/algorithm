package beakjoon.before;

import java.util.Scanner;
import java.util.Stack;

public class P10799 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.next()));
    }

    public static int solution(String input) {

        Stack<Character> stack = new Stack<>();
        int boardCount = 0;
        int totalCount = 0;

        for (char character : input.toCharArray()) {

            if (character == '(') {
                boardCount++;
                totalCount++;
            } else if (character == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') { // 레이저 인 경우
                    boardCount--;
                    totalCount--;
                    totalCount += boardCount;
                } else {
                    boardCount--;
                }
            }

            stack.push(character);

        }

        return totalCount;
    }
}
