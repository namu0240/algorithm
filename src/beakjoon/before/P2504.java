package beakjoon.before;

import java.util.Scanner;
import java.util.Stack;

public class P2504 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.next()));
    }

    private static int solution(String data) {

        Stack<String> stringStack = new Stack<>();

        for (String inputValue : data.split("")) {

            // 이상한 값이면 걸러야 함!!!....

            if (inputValue.equals("(") || inputValue.equals("[")) {
                stringStack.push(inputValue);
            } else {
                // 잘못 된 값의 경우 예외 처리
                if (stringStack.isEmpty()) {
                    return 0;
                }

                if (inputValue.equals(")")) {
                    if (!innerCalculate(stringStack, "(", "["))
                        return 0;
                } else {
                    if (!innerCalculate(stringStack, "[", "("))
                        return 0;
                }
            }

        }

        return resultCalculate(stringStack);
    }

    public static boolean innerCalculate(Stack<String> stringStack, String yes, String no) {

        // 합계
        int sum = 0;
        // 주어진 괄호에 대한 값
        int mul = yes.equals("(") ? 2 : 3;

        // 스택이 비어질 동안
        while (!stringStack.isEmpty()) {
            String popString = stringStack.pop();

            // 스택의 마지막 값이 허용하지 않는 값이면
            if (popString.equals(no))
                return false;

            // 스택의 마지막 값이 허용 하는 값이면
            else if (popString.equals(yes)) {
                // 값을 더하고
                sum = (sum == 0) ? 1 : sum;
                // 값을 넣는다.
                stringStack.push(Integer.toString(sum * mul));
                return true;
            } else {
                sum += Integer.parseInt(popString);
            }
        }
        return false;
    }

    public static int resultCalculate(Stack<String> stringStack) {
        int sum = 0;
        while (!stringStack.isEmpty()) {
            try {
                int popValue = Integer.parseInt(stringStack.pop());
                sum += popValue;
            } catch (Exception exception) {
                return 0;
            }
        }
        return sum;
    }

}
