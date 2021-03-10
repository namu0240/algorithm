package beakjoon.before;

import java.util.Scanner;
import java.util.Stack;

public class P5397 {

    /**
     * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한줄로 이루어져 있고,
     * 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000) 강산이가 백스페이스를 입력했다면,
     * '-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다. 화살표의 입력은 '<'와 '>'로 주어진다.
     * 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 나머지 문자는 비밀번호의 일부이다.
     * 물론, 나중에 백스페이스를 통해서 지울 수는 있다. 만약 커서의 위치가 줄의 마지막이 아니라면, 그 문자를 입력하고,
     * 커서는 오른쪽으로 한 칸 이동한다.
     * <p>
     * <<BP<A>>Cd-
     * ThIsIsS3Cr3t
     * <p>
     * BAPC
     * ThIsIsS3Cr3t
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solution(scanner.next()));
        }
//        System.out.println(solution("ab<-<cd>>e")); // cdbe
//        System.out.println(solution("a--------")); // cdbe
//        System.out.println(solution("<<BP<A>>Cd-")); // cdbe
//        System.out.println(solution("ThIsIsS3Cr3t")); // cdbe
    }

    public static String solution(String input) {
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> subStack = new Stack<>();

        for (char key : input.toCharArray()) {
            switch (key) {
                case '<':
                    if (mainStack.isEmpty()) {
                        continue;
                    }
                    subStack.push(mainStack.pop());
                    break;
                case '>':
                    if (subStack.isEmpty()) {
                        continue;
                    }
                    mainStack.push(subStack.pop());
                    break;
                case '-':
                    if (mainStack.isEmpty()) {
                        continue;
                    }
                    mainStack.pop();
                    break;
                default:
                    mainStack.push(key);
                    break;
            }

        }

        while (!subStack.isEmpty()) {
            mainStack.push(subStack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : mainStack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

}
