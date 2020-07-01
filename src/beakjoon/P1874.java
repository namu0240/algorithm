package beakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] completionGoal = new int[N];

        for (int i = 0; i < N; i++) {
            completionGoal[i] = scanner.nextInt();
        }

        List<String> result = solution(N, completionGoal);

        if (result == null) {
            System.out.println("NO");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }

    }

    private static List<String> solution(int n, int[] completionGoal) {
        List<String> result = new ArrayList<>();
        int cursor = 0;

        Stack<Integer> integerStack = new Stack<>();
        for (int i = 1; i <= n; i++) {

            // 우선 아이템을 넣습니다.
            integerStack.push(i);
            result.add("+");

            // 커서부터 목표 배열까지 탐색합니다.
            for (int j = cursor; j < completionGoal.length; j++) {

                // 일치하지 않는 숫자의 경우 다음으로 넘어 갑니다.
                if (integerStack.empty() || completionGoal[cursor] != integerStack.peek()) {
                    break;
                }

                // 만약 일치 할 경우 연산을 수행합니다.
                integerStack.pop();
                result.add("-");
                cursor++;
            }
        }

        return cursor == completionGoal.length ? result : null;
    }

}
