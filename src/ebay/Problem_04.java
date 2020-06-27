package ebay;

import java.util.Random;

public class Problem_04 {

    public int solution(String s) {

        int answer = 0;
        int length = s.length() / 2;
        int min = s.length();

        for (int i = 1; i <= s.length(); i++) { // count
            String findWord = s.substring(0, i);
            for (int j = 0; j < s.length(); j += i) {

                if (j + i >= s.length()) {
                    break;
                }

                String checkWord = s.substring(j, j + i);

                System.out.println(String.format("findWord: %s, checkWord: %s", findWord, checkWord));

                if (!findWord.equals(checkWord)) {
                    break;
                }

                if (j == s.length() - 1) {
                    int result = s.length() / findWord.length();

                    if (min > result) {
                        min = result;
                    }
                }
            }
        }

        return min;
    }
}
