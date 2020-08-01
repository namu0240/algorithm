package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Android_4 {

    /**
     * [Android-4] 소비내역 기초 분석
     * 4sec
     * 토스에 카드를 연결하면 그 카드의 결제 내역 데이터를 가공해 소비 활동에 유용하게 사용할 수 있는 정보를 얻을 수 있습니다.
     *
     *
     *
     * 이러한 분석의 첫 단계로, 유저들의 결제 내역 데이터를 통해 어디에서 가장 많은 소비를 했고, 어디를 가장 자주 방문했는지 찾아서 앞으로의 소비 생활에 참고하려고 합니다.
     *
     *
     *
     * 가게 이름과 소비 금액으로 구성된 데이터를 입력받아, 가장 소비 금액이 높은 가게 이름(들)과 가장 자주 방문한 가게 이름(들)을 출력하는 프로그램을 작성해 주십시오.
     *
     *
     *
     * 입력 설명
     *
     * 첫 번째 줄에는 결제 내역 데이터의 개수 n이 주어집니다. (1 <= n <= 100,000)
     *
     * 이후 n줄에 걸쳐 가게 이름과 소비 금액이 ‘,’ 로 연결되어 입력됩니다.
     *
     * 가게 이름은 영문 알파벳 대소문자로 이루어져 있으며, 소비 금액의 총합은  0 초과 10,000,000 이하입니다.
     *
     * 가게 이름의 대소문자는 구분하지 않습니다.
     *
     *
     *
     *
     *
     * 출력 설명
     *
     * 첫 번째 줄에는 총 소비 금액이 가장 많은 가게를 출력합니다. 1개가 아닌 경우, 대소문자 구별 없이 알파벳 순으로(a->z) 정렬된 상태로 ‘,’ 로 연결해 출력해주십시오.
     *
     * 두 번째 줄에는 방문 횟수가 가장 많은 가게를 출력합니다. 1개가 아닌 경우, 대소문자 구별 없이 알파벳 순으로(a->z) 정렬된 상태로 ‘,’ 로 연결해 출력해주십시오.
     * <p>
     * Example 1
     * Input
     * 6
     * Mart,50000
     * GasStation,100000
     * coffeeShop,13500
     * coffeeShop,2500
     * GasStation,50000
     * Drugstore,80000
     * Output
     * GasStation
     * coffeeShop,GasStation
     *
     * Example 2
     * Input
     * 10
     * C,139500
     * E,947300
     * B,299500
     * A,92500
     * A,6000
     * D,937000
     * E,878800
     * A,9900
     * E,5800
     * C,10050
     * Output
     * E
     * A,E
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void solution(String[] dateList) {

    }

}
