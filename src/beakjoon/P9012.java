package beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class P9012 {
    public static int T;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            char[] charArray = scanner.next().toCharArray();

            if(isVPS(charArray)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isVPS(char[] charArray) {
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {

            // 만약 ( 일 경우 Stack 에 저장합니다.
            if (c == '(') {
                stack.push(c);
                continue;
            }

            // 만약 ) 일 경우 스택에서 Pop 을 합니다.
            if(stack.isEmpty()) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
