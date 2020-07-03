package beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class P2504 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(solution(scanner.next()));
        System.out.println(solution("(((())))"));
    }

    private static int solution(String formula) {
        int result = 0;
        Stack<String> characterStack = new Stack<>();

        for (String operator : formula.split("")) {

            // 열린 괄호면 스택에 푸쉬
            if (isOpener(operator)) {
                characterStack.push(operator);
                continue;
            }

            // 닽힌 괄호일 경우
            if (isCloser(operator)) {

                String peekValue = characterStack.peek();

                // 스택의 마지막 값이 열린 괄호면 팝을 하고 숫자를 푸쉬
                if (isOpener(peekValue)) {
                    characterStack.pop();
                    characterStack.push(peekValue.equals("(") ? "2" : "3");
                    continue;
                }

                // 스택의 마지막 값이 숫자 일 경우
                if (isNumber(peekValue)) {
                    // 괄호를 만날때 까지 더하고 곱한 다음 푸쉬
                    int sumValue = 0;
                    while (isNumber(characterStack.peek())) {
                        sumValue += Integer.parseInt(characterStack.pop());
                    }
                    characterStack.pop();
                    characterStack.push(String.valueOf(sumValue * (operator.equals(")") ? 2 : 3)));
                    continue;
                }

                characterStack.push(operator);
            }
        }

        while (!characterStack.isEmpty()) {
            result += Integer.parseInt(characterStack.pop());
        }

        return result;
    }

    private static boolean isOpener(String character) {
        return character.equals("(") || character.equals("[");
    }

    private static boolean isCloser(String character) {
        return character.equals(")") || character.equals("]");
    }

    private static boolean isNumber(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
