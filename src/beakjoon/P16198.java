package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P16198 {

    static int n;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> energyWeight = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            energyWeight.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        for (int i = 1; i < n - 1; i++) {
            solution(new ArrayList<>(energyWeight), i, 0);
        }

        System.out.println(result);

    }

    public static void solution(List<Integer> energyWeight, int number, int max) {

        // W(x-1) * W(x+1)의 에너지를 모은다.
        int energy = energyWeight.get(number - 1) * energyWeight.get(number + 1);

        // X번째 에너지 구슬을 제거한다.
        // N을 1 감소시키고, 에너지 구슬을 1번주터 N 번까지 다시 번호를 매긴다.
        energyWeight.remove(number);

        // 첫번쨰와 마지막 구슬을 고를 수 없기 때문에 사이즈가 2일 경우 끝을 의미
        if (energyWeight.size() == 2) {
            result = Math.max(result, max + energy);
            return;
        }

        // 첫 번째와 마지막 에너지 구슬을 고를 수 없기 때문에 1 ~ (N-1)
        for (int i = 1; i < energyWeight.size() - 1; i++) {
            solution(new ArrayList<>(energyWeight), i, max + energy);
        }

    }

}
