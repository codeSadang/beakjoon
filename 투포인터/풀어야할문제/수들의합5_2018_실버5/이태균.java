package 투포인터.풀어야할문제.수들의합5_2018_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int N;
    public static int TARGET;
    public static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        TARGET = N;
        ARR = new int[N];
        for (int i = 0; i < N; i++) {
            ARR[i] = i + 1;
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (left <= right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += ARR[i];
            }

            if (sum == TARGET) {
                left++;
                count++;
            } else if (sum < TARGET) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(count);
    }
}