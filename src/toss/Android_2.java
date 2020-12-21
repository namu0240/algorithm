package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Android_2 {

    /**
     * 토스신용카드 발급을 희망하는 사용자들이 있습니다.
     * <p>
     * 마케팅과 혜택 개발을 위한 데이터로 활용하기 위해 같은 지역에 거주하는 사용자들을 구분하려고 할 때,
     * <p>
     * 발급 신청서에 기록된 사용자들의 주소지를 가장 작은 행정구역 단위로 그룹핑하는 프로그램을 작성해주십시오.
     * <p>
     * <p>
     * <p>
     * 입력 설명
     * <p>
     * 첫 번째 줄에는 각 발급 신청자들의 주소지 수 N이 주어집니다.
     * 두 번째 줄부터 N줄에 걸쳐 발급을 희망하는 사람들의 주소지가 주어집니다.
     * 이 때, 주소지들의 행정구역 단위는 온점(.)으로 구분합니다.
     * 입력된 주소지의 가장 마지막 주소 단위는 버립니다.
     * 입/출력 예시 4번 참고
     * 한 주소지당 2단계 이상의 구역이 입력됩니다.
     * <p>
     * <p>
     * 출력 설명
     * <p>
     * 입력된 주소지들을 모두 포함하는 가장 작은 행정구역
     * 모두 포함하는 구역을 찾을 수 없을 경우, 없음을 출력합니다.
     * 입력할 주소지의 수가 1 이하일 경우, 없음을 출력합니다.
     * <p>
     * Example 1
     * Input
     * 3
     * 경기도.수원시.영통구.법조로
     * 경기도.수원시.영통구.삼성로
     * 경기도.수원시.영통구.법조로30
     * Output
     * 경기도.수원시.영통구
     * <p>
     * Example 2
     * Input
     * 4
     * 서울특별시.송파구.충민로
     * 경기도.성남시.분당구.불정로
     * 서울특별시.송파구.충민로3
     * 서울특별시.송파구
     * Output
     * 없음
     * <p>
     * Example 3
     * Input
     * 2
     * 경기도.안산시.상록구.초지1로
     * 경기도.안산시.상록구.초지1로20
     * Output
     * 경기도.안산시.상록구
     * <p>
     * Example 4
     * Input
     * 2
     * 경기도.안양시.만안구
     * 경기도.안양시.만안구.덕천로
     * Output
     * 경기도.안양시
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] address = new String[count];
        for (int i = 0; i < count; i++) {
            address[i] = br.readLine();
        }
        System.out.println(solution(address));
    }

    public static String solution(String[] addressList) {
        String[] addressGroup = new String[100];
        int cycle = 0;

        for (String address : addressList) {
            String[] zone = address.split(Pattern.quote("."));
            if (!setZone(zone, addressGroup, cycle)) {
                return "없음";
            }
            cycle++;
        }

        StringJoiner addressUnitList = new StringJoiner(".");

        for (String s : addressGroup) {
            if (s == null || s.isEmpty()) {
                break;
            }
            addressUnitList.add(s);
        }

        return addressUnitList.toString();
    }

    public static boolean setZone(String[] zone, String[] addressGroup, int cycle) {
        for (int i = 0; i < zone.length; i++) {

            // 비어있으면 넣고
            if (addressGroup[i] == null) {
                if (cycle != 0) {
                    addressGroup[i] = "";
                    continue;
                }
                addressGroup[i] = zone[i];
                continue;
            }

            // 서로 다르면
            if (!addressGroup[i].equals(zone[i])) {

                // 처음부터 다르면 없음.
                if (i == 0) {
                    return false;
                }

                // 그게 아니라면 서로 상쇄
                addressGroup[i] = "";
                return true;

            }

            // 서로 같으면 통과
        }

        addressGroup[zone.length - 1] = "";
        return true;
    }

}
