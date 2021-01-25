package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16968 {

    static char[] chars;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        chars = bufferedReader.readLine().toCharArray();
        solution(1, chars[0] == 'd' ? 10 : 26);
        System.out.println(sum);
    }

    public static void solution(int index, long total) {
        if (index == chars.length) {
            sum = total;
            return;
        }

        // 만약 이전의 문자열과 동일하지 않을 경우 처음으로 다시 리셋
        if (chars[index] == chars[index - 1]) {
            if (chars[index] == 'd') {
                total *= 9;
            } else { // 'c'
                total *= 25;
            }
        }
        // 만약 이전의 문자열이 동일 할 경우 -1 해서 더한다
        else {
            if (chars[index] == 'd') {
                total *= 10;
            } else { // 'c'
                total *= 26;
            }
        }

        solution(index + 1, total);
    }

}
