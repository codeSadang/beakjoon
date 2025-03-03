package class3.풀어야할문제.ATM_11399_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 인하은행에는 ATM이 1대밖에 없다.
 * N 명의 사람이 줄을 . 있고,
 * i번째 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.
 *
 *
 */
public class 황병수 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] timeList = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            timeList[i]  = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeList);

        result += timeList[0];

        for (int i = 1; i < N; i++) {
            timeList[i] += timeList[i-1];
            result += timeList[i];
        }

        System.out.println(result);
    }
}
