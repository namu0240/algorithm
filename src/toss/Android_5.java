package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Android_5 {

    /**
     * [Android-5] 송금 금액 한글 단위 표시
     * 4sec
     * 토스 송금 화면에서 사용자가 입력한 금액 아래에, 금액을 한글 단위로 변환하여 표시해주고 있습니다. (아래 화면에서 12만 5,000원)
     *
     * 사용자가 입력한 금액을 한글 단위로 변환하는 기능을 구현해주십시오.
     *
     *
     *
     * 조건
     *
     * '조', '억', '만' 단위를 변환해주세요.
     * 변환된 한글 단위 뒤에는 공백이 있어야 합니다.
     * ('조', '억', '만' 단위 뒤에 띄어쓰기 필요)
     * '숫자'와 '원'은 붙여써야 합니다.
     * 주어진 금액에는 천 단위 구분자(,)가 포함될 수 있습니다.
     * 결과값에는 천 단위 구분자(,)가 꼭 포함되어야 합니다.
     * 입력되는 금액은 9,999,999,999,999,999원을 초과하지 않습니다.
     *
     *
     * 입력 설명
     *
     * 첫 번째 줄에는 입력 데이터의 개수 N(20이하의 자연수), 이후 N개의 데이터가 각 줄에 하나씩 주어집니다.
     *
     *
     * 출력 설명
     *
     * 한글 단위로 변환된 N개의 결과를 한 줄에 하나씩 출력해주십시오.
     * <p>
     * Example 1
     * Input
     * 7
     * 5,000
     * 50,000
     * 500,000
     * 5,000,000
     * 50,000,000
     * 500,000,000
     * 5,000,000,000
     * Output
     * 5,000원
     * 5만원
     * 50만원
     * 500만원
     * 5,000만원
     * 5억원
     * 50억원
     *
     * Example 2
     * Input
     * 2
     * 1234567890
     * 100200300400500
     * Output
     * 12억3,456만7,890원
     * 100조2,003억40만500원
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void solution(String[] dateList) {

    }

}
