package 다이나믹프로그래밍.풀어야할문제.포도주시식_2156_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static int[] wine;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        wine = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        // 초기값 설정
        dp[1] = wine[1];
        if (N > 1) dp[2] = wine[1] + wine[2];

        // DP 점화식 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}
