package programmers;

import java.util.Arrays;

public class P43164 {

    public static void main(String[] args) {
        String[] result1 = solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println("result1 is = " + Arrays.toString(result1));
        System.out.println(Arrays.equals(result1, new String[]{"ICN", "JFK", "HND", "IAD"}));

        String[] result2 = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        System.out.println("result2 is = " + Arrays.toString(result2));
        System.out.println(Arrays.equals(result2, new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}));
    }

    public static String[] solution(String[][] tickets) {
        return recursive(tickets, "ICN", new boolean[tickets.length], new String[tickets.length + 1], 0);
    }

    public static String[] recursive(String[][] tickets, String start, boolean[] visit, String[] visits, int index) {
        System.out.println("recursive() called with: tickets = [" + Arrays.deepToString(tickets) + "], start = [" + start + "], visit = [" + Arrays.toString(visit) + "], visits = [" + Arrays.toString(visits) + "], index = [" + index + "]");

        // 이동 및 방문 기록 남기기
        visits[index++] = start;

        // ===== [ BREAK POINT ] =====

        // 더 이상 사용 가능한 티켓이 있는지 없는지는 확인하기 위한 변수
        boolean isAlreadyVisit = false;

        // 만약에 모든 티켓을 사용하였다면 종료
        for (boolean b : visit) {
            if (!b) {
                isAlreadyVisit = true;
                break;
            }
        }

        // 더 이상 사용할 티켓이 없다면 종료
        if (!isAlreadyVisit) {
            return visits;
        }

        // ===== [ BREAK POINT ] =====

        // next point
        // 우선 적으로 다음 이동 할 장소
        String nextArrive = "Z";
        // 해당 티켓의 인덱스
        int nextIndex = 0;

        // 출발지를 기준으로 갈 수 있는 곳을 찾아 최단거리 변수에 비교하여 넣는다.
        for (int i = 0; i < tickets.length; i++) {

            // 출발지가 같은 곳을 찾는다.
            if (!tickets[i][0].equals(start)) {
                continue;
            }

            // 이미 사용한 티켓이면 다음 티켓
            if (visit[i]) {
                continue;
            }

            // 이전에 포인트를 잡을 곳에서 더 가까운 곳을 찾는다.
            if (isFar(nextArrive, tickets[i][1])) {
                nextArrive = tickets[i][1];
                nextIndex = i;
            }

        }

        visit[nextIndex] = true;
        return recursive(tickets, nextArrive, visit, visits, index);

    }

    public static boolean isFar(String pos1, String pos2) {
        int posChar1 = pos1.charAt(0); // char == int
        int posChar2 = pos2.charAt(0);
        return posChar1 > posChar2;
    }

}
