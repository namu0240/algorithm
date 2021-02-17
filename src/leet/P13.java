package leet;

public class P13 {

    static int[] values;

    public static void main(String[] args) {

        values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        String input = "MCMXCIV";
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
//             CM, XC, IV
//            if (values[input.charAt(i) - 'A'] < values[chars[i + 1] - 'A']) {
//                sum = values[chars[i] - 'A'] + values[chars[i + 1] - 'A'];
//            } else {
//                sum = values[chars[i] - 'A'];
//            }
        }

        /**
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */

        /**
         * Input: s = "MCMXCIV"
         * Output: 1994
         * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
         */

    }

    public static void solution() {

    }

}
