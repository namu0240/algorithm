package sw;

import java.util.Scanner;

public class P20201217 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N 입력
        int n = scanner.nextInt();
        // 최소 값을 구하기 위해서는 최대값으로 부터 시작을 해야함, 0이 가장 작은 값이기에 초기화 필요
        int min = Integer.MAX_VALUE;
        // 반복문을 돌 횟수, 입력받은 수의 제곱근을 구하여 나머지 값을 고려하여 1 더함
        // 귀찮으면 포문에서 n 까지 받고 if 문을 걸어 제한을 둬도 상관없음.
        int maxSize = (int) Math.sqrt(n) + 1;

        for (int i = 1; i < maxSize; i++) {
            min = Math.min(min, solution(n, i));
        }

        System.out.println(min);
    }

    private static int solution(int orderSize, int squareLength) {
        System.out.println(String.format("called solution with: orderSize=[%d], squareLength=[%d]", orderSize, squareLength));

        // 연산 횟수
        int operationCount = 0;
        // 사각형 크기
        int squareSize = squareLength * squareLength;

        // n이 0이 아닐때 까지 반복, 0일 경우 종료해야함.
        while (orderSize != 0) {

            // 제곱 한 수를 뺼때 만약 결과값이 음수라면 정사각형 크기를 줄여햐함.
            if (orderSize - squareSize < 0) {
                squareLength -= 1;
                squareSize = squareLength * squareLength;
                continue;
            }

            // 주문한 크기에서 제곱한 수를 뺌.
            orderSize -= squareSize;
            operationCount++;
        }

        return operationCount;
    }

}
