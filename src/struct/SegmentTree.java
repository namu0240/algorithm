package struct;

import java.util.Arrays;

public class SegmentTree {

    /**
     * 루트 노드를 기준으로 왼쪽 노드는 (루트노드 * 2) 오른쪽 노드는 (루트노드 * 2 + 1)
     */
    private final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private int[] tree = new int[numbers.length * 4];

    public SegmentTree() {
        init(1, numbers.length - 1, 1);

        System.out.println(Arrays.toString(tree));
        System.out.println("1 ~ 10의 합 : " + sum(1, numbers.length, 1, 1,10));
        System.out.println("3 ~ 9의 합 : " + sum(1, numbers.length, 1, 3, 9));
    }

    /**
     * 세그먼트 트리 구현
     *
     * @param start 시작 인덱스
     * @param end   종료 인덱스
     * @param node  노드
     * @return 해당 위치의 총합
     */
    public int init(int start, int end, int node) {
        // 만약 입력된 숫자의 길이가 1인 경우
        if (start == end) {
            return tree[node] = numbers[start];
        }
        /*
        미드를 구하는 이유?
        부모는 좌측, 우측의 노드의 합임
         */
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public int sum(int start, int end, int node, int left, int right) {
        System.out.printf("%d ~ %d의 합%n", start, end);
        // 범위 밖에 있는 경우
        if (left > end || right < start) return 0;
        // 범위 안에 있는 경우
        if (left <= start && end <= right) return tree[node];
        // 그렇지 않다면 두 부분으로 나누어 합을 구하기
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public void update() {

    }

}
