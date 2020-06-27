package ebay;

public class Problem_03 {

    // require 최적화

    public int solution(String s) {
        int answer = 0;

        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++) { // start index
            for (int j = i; j < input.length; j++) {

                if (i == j){
                    continue;
                }

                boolean result = move(input, i, j, 0);
                if (result) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public boolean move(
            char[] input,
            int startIndex,
            int endIndex,
            int weight
    ) {

        switch (input[startIndex]) {
            case 'U':
                weight += 20;
                break;
            case 'D':
                weight -= 20;
                break;
            case 'L':
                weight += 1;
                break;
            case 'R':
                weight -= 1;
                break;
        }

        if (startIndex == endIndex) {
            return weight == 0;
        }

        return move(input, ++startIndex, endIndex, weight);
    }

}
