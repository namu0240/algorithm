package toss;

import jdk.nashorn.internal.parser.DateParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Android_3 {

    /**
     * 토스 알림은 사용자의 금융 활동, 이벤트와 관련된 메세지를 시간 순으로 보여주는 기능입니다.
     * <p>
     * <p>
     * <p>
     * 실시간으로 사용자의 행동에 따라 알림이 발송되기 때문에 날짜를 그대로 보여주는 것보다 상대 시간으로 변환해 보여주는 것이 사용성을 높일 수 있습니다.
     * <p>
     * <p>
     * <p>
     * 따라서 최근 1년 이내의 알림은 방금 전, 10개월 전과 같이 상대 시간으로 노출하려고 합니다.
     * <p>
     * <p>
     * <p>
     * 날짜를 상대 시간으로 변환하는 프로그램을 작성해주십시오.
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 입력 형식
     * 첫째 줄에는 testCase의 개수 N을 입력합니다. (0 < N <= 20)
     * <p>
     * 둘째 줄에는 기준 날짜를 입력합니다.
     * <p>
     * 셋째 줄부터 N줄 동안 각 알림을 받은 날짜를 입력합니다.
     * <p>
     * 날짜 형식은 한국 기준 "yyyy-MM-dd HH:mm:ss"입니다.
     * <p>
     * 출력 형식
     * 입력받은 날짜를 상대 시간으로 변환해 N줄에 걸쳐 출력합니다.
     * <p>
     * 기준 날짜로 부터 경과된 상대 시간을 "n{단위} 전"으로 출력해주세요. 상대 시간은 분, 시간, 일, 개월 단위로 표현할 수 있습니다.
     * <p>
     * 1분 미만 내 받은 알림은 "방금 전"으로 출력합니다.
     * <p>
     * 1년 이상 경과한 알림은 "yy년 M월 d일"로 출력합니다.
     * <p>
     * 입력 형식이 틀렸거나 기준 날짜보다 미래 날짜가 입력된 경우 "error"를 출력합니다.
     * <p>
     * <p>
     * <p>
     * ※ 이 문제를 해결하는 다양한 방법이 있습니다. 만약 문제 해결 과정에서 1달, 1년의 기준이 필요하다면, 1달은 30일, 1년은 365일로 가정하고 계산해주세요.
     * <p>
     * Example 1
     * Input
     * 5
     * 2020-08-01 12:00:00
     * 2020-08-01 11:50:00
     * 2020.08.01 11:00:00
     * 2019-08-10 14:00:00
     * 2019-08-01 11:00:00
     * 2020-07-30 12:00:00
     * Output
     * 10분전
     * error
     * 11개월전
     * 19년8월1일
     * 2일전
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] dateList = new String[count];
        for (int i = 0; i < count; i++) {
            dateList[i] = br.readLine();
        }
        solution(dateList);
    }

    public static void solution(String[] dateList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        for (String date : dateList) {
            Calendar alarmCalendar = Calendar.getInstance();
            alarmCalendar.setTime(simpleDateFormat.parse(date, new ParsePosition(0)));
            System.out.println(getRelativeTime(alarmCalendar));
        }
    }

    public static String getRelativeTime(Calendar alarmCalendar) {
        Calendar nowCalendar = Calendar.getInstance();
        long diffTime = nowCalendar.getTime().getTime() - alarmCalendar.getTime().getTime();
        return "";
    }

}
