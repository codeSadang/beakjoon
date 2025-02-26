package 다이나믹프로그래밍.풀어야할문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이태균 {

    public static int N;
    public static int[] STAIR_LIST;
    public static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        STAIR_LIST = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            STAIR_LIST[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(STAIR_LIST[1]);
            return;
        }

        DP = new int[N + 1];
        DP[1] = STAIR_LIST[1];
        DP[2] = STAIR_LIST[1] + STAIR_LIST[2];

        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 2], DP[i - 3] + STAIR_LIST[i - 1]) + STAIR_LIST[i];
            System.out.println(Arrays.toString(DP));
        }

        System.out.println(DP[N]);
    }
}