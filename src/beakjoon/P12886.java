package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12886 {

    // Q. 돌 세개는 그룹으로 나누어져 있으며 각각의 그룹에는 돌이 A, B, C개가 있다.
    // 강호는 모든 그룹에 있는 돌의 개수를 같게 만들려고 한다.

    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static int[] group = new int[3];
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < 3; i++) {
            group[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solution(group);
    }

    public static void solution(int[] startGroup) {
        // 크기가 같지 않은 두 그룹을 고른다.

        Queue<int[]> queue = new LinkedList<>();
        queue.add(startGroup);

        while (!queue.isEmpty()) {

            int[] group = queue.poll();

            // 모두다 같으면 1 출력 후 종료
            if (group[A] == group[B] && group[B] == group[C]) {
                System.out.println(1);
                return;
            }

            // 정렬 한번
            Arrays.sort(group);

            // 이전에 확인 하였던 그룹인지 확인
            if (visited.contains(Arrays.toString(group))) {
                continue;
            }

            // 그룹에 추가
            visited.add(Arrays.toString(group));

            if (group[A] != group[B]) {
                int na = group[A] + group[A];
                int nb = group[B] - group[A];

                queue.add(new int[]{na, nb, group[C]}); // 여기서 미리 객체 생성과 동시에 정렬?
            }

            if (group[A] != group[C]) {
                int na = group[A] + group[A];
                int nc = group[C] - group[A];

                queue.add(new int[]{na, group[B], nc}); // 여기서 미리 객체 생성과 동시에 정렬?
            }

            if (group[B] != group[C]) {
                int nb = group[B] + group[B];
                int nc = group[C] - group[B];

                queue.add(new int[]{group[A], nb, nc}); // 여기서 미리 객체 생성과 동시에 정렬?
            }

        }

        System.out.println(0);

    }

}
