package 투포인터.풀어야할문제.용액_2467_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] ARR;

    public static int MIN = Integer.MAX_VALUE;
    public static int[] RESULT = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ARR = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        two_pointer();

        System.out.println(RESULT[0] + " " + RESULT[1]);
    }

    private static void two_pointer() {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = ARR[left] + ARR[right];

            if (MIN > Math.abs(sum)) {
                MIN = Math.min(MIN, Math.abs(sum));

                RESULT[0] = ARR[left];
                RESULT[1] = ARR[right];
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
    }

}