package beakjoon.week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P12015 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(0);

        int n = Integer.parseInt(bufferedReader.readLine());


        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {

            int val = Integer.parseInt(stringTokenizer.nextToken());

            if (integerArrayList.get(integerArrayList.size() - 1) < val) {
                integerArrayList.add(val);
                continue;
            }

            int left = 1;
            int right = integerArrayList.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (integerArrayList.get(mid) < val) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            integerArrayList.set(right, val);
        }

        System.out.println(integerArrayList.size() - 1);

    }

}
