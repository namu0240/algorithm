package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Android_1 {

    /**
     * RGB Hex Color Code와 Alpha 값을 입력 받아 ARGB로 출력하십시오.
     * <p>
     * <p>
     * 조건
     * <p>
     * 컬러 코드는 #FFFFFF 처럼 #을 항상 포함하고,
     * 대문자와 숫자만 사용됩니다.
     * Alpha 값은 0이상 100이하의 정수입니다.
     * (Alpha 0 : 완전 투명 / Alpha 100 : 불투명)
     * 소수점 이하는 버림해주세요. (예시2 참고)
     * <p>
     * <p>
     * 입력 설명
     * <p>
     * 색상 코드와 Alpha값이 쉼표(,) 로 구분되어 입력됩니다.
     * <p>
     * <p>
     * 출력 설명
     * <p>
     * 투명도가 적용된 색상 코드를 출력해주십시오.
     * <p>
     * Example 1
     * Input
     * #FFFFFF,0
     * Output
     * #00FFFFFF
     * <p>
     * Example 2
     * Input
     * #FFFFFF,50
     * Output
     * #7FFFFFFF
     * <p>
     * Example 3
     * Input
     * #00FF00,100
     * Output
     * #FF00FF00
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));
    }

    public static String solution(String input) {
        String[] inputs = input.split(",");
        int percent = Integer.parseInt(inputs[1]);
        String alpha = String.format("%02X", (int) Math.floor(percent / 100.0 * 0xFF));
        String colorCode = inputs[0].replace("#", "");
        return String.format("#%s%s", alpha, colorCode);
    }

}
