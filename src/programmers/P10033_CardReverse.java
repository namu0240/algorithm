package samsungexpert;

import java.util.Scanner;

public class P10033_CardReverse {

    static int T;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            int result = solution(scanner.nextLine().toCharArray(), 0);
            System.out.println(String.format("#%d %d", i + 1, result));
        }

    }

    public static int solution(char[] cards, int depth) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i] == 'B' && cards[i + 1] == 'W') {
                cards[i] = 'W';
                cards[i + 1] = 'B';
                depth++;
                i = 0;
            }
        }

        return depth;
    }

}
