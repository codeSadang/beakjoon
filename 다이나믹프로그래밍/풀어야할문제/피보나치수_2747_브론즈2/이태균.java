package 다이나믹프로그래밍.풀어야할문제.피보나치수_2747_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int N;
    public static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;

        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }

        System.out.println(DP[N]);
    }

}