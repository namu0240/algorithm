package ebay;

public class Problem_01 {

    public int[] solution(int[] arr) {
        int[] answer;

        int[] duplicateRemovedArray = new int[100000];

        int answerSize = 0;

        for (int i : arr) {
            if (duplicateRemovedArray[i] == -1) {
                continue;
            }

            if (duplicateRemovedArray[i] != 0) {
                duplicateRemovedArray[i] = -1;
                answerSize--;
            } else {
                duplicateRemovedArray[i] = i;
                answerSize++;
            }
        }

        System.out.println(String.format("answerSize: %d", answerSize));

        if (answerSize == 0) {
            answer = new int[]{-1};
        } else {
            int[] answerArray = new int[answerSize];
            int cnt = 0;
            for (int i : duplicateRemovedArray) {
                if (i == 0 || i == -1) {
                    continue;
                }
                answerArray[cnt] = i;
                cnt++;
            }
            answer = answerArray;
        }

        return answer;
    }

}
