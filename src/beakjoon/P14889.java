package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    static int n;
    static int[][] ability;
    static boolean[] isVisible;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        min = Integer.MAX_VALUE;
        ability = new int[n][n];
        isVisible = new boolean[n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        makeTeam(0, 0);

        System.out.println(min);
    }

    public static void makeTeam(int index, int memberCount) {
        // 팀이 다 짜여졌다면 능력치 계산
        if (memberCount == n / 2) {
            calculateAbilityDiff();
            return;
        }

        for (int i = index; i < n; i++) {
            if (isVisible[i]) {
                continue;
            }

            isVisible[i] = true;
            makeTeam(i, memberCount + 1);
            isVisible[i] = false;
        }
    }

    public static void calculateAbilityDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        // 1부터 N까지 탐색
        for (int i = 0; i < n; i++) {
            // i 부터 시작하는 이유는 i가 1일때 j가 2, i가 2일때 j가 1 같은 역전의 경우를 사전차단
            for (int j = i; j < n; j++) {

                // 같은 숫자라면 스킵
                if (i == j) {
                    continue;
                }

                // i 번째 사람과 j 번째 사람이 true 라면 스타트 팀으로 점수 계산
                if (isVisible[i] && isVisible[j]) {
                    startTeam += ability[i][j];
                    startTeam += ability[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false 라면 링크 팀으로 점수 계산
                else if (!isVisible[i] && !isVisible[j]) {
                    linkTeam += ability[i][j];
                    linkTeam += ability[j][i];
                }
            }
        }

        // 두 팀의 점수차이를 계산하여 최솟값 갱신
        min = Math.min(min, Math.abs(startTeam - linkTeam));

        // 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 떄문에 종료
        if (min == 0) {
            System.out.println(min);
            System.exit(0);
        }
    }

}
