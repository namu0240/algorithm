package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Android_6 {

    /**
     * [Android-6] 입금, 출금 경우의 수 계산하기
     * 4sec
     * 한 번에 만 원씩만 입출금이 가능한 계좌가 있습니다.
     * 현재 계좌 잔액이 k만원이고, 입금을 n번, 출금을 m번 하려고 할 때,
     * 가능한 경우의 수를 구하십시오.
     *
     *
     *
     *
     *
     * 조건
     *
     * 계좌의 잔액은 음수가 될 수 없습니다.
     * 입력값은 m <= (k + n)을 항상 만족하며,
     * n, m, k 는 각각 0 이상 15이하의 정수입니다.
     *
     *
     * 입력 설명
     *
     * n, m, k
     * n: 입금 횟수
     * m: 출금 횟수
     * k: 계좌 잔액 k만원
     *
     *
     * 출력 설명
     *
     * 총 x가지
     * x: 가능한 경우의 수
     *
     *
     *
     *
     * 아래 [예시 1]에 대한 풀이
     *
     * 입금 - 입금 - 출금 - 출금 - 출금
     * 입금 - 출금 - 입금 - 출금 - 출금
     * 입금 - 출금 - 출금 - 입금 - 출금
     * 입금 - 출금 - 출금 - 출금 - 입금 (X)
     * 출금 - 입금 - 입금 - 출금 - 출금
     * 출금 - 입금 - 출금 - 입금 - 출금
     * 출금 - 입금 - 출금 - 출금 - 입금 (X)
     * 출금 - 출금 - 입금 - 입금 - 출금 (X)
     * 출금 - 출금 - 입금 - 출금 - 입금 (X)
     * 출금 - 출금 - 출금 - 입금 - 입금 (X)
     *
     * Example 1
     * Input
     * 2,3,1
     * Output
     * 총5가지
     *
     * Example 2
     * Input
     * 7,6,5
     * Output
     * 총1715가지
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void solution(String[] dateList) {

    }

}
