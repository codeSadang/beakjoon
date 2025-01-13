package 다이나믹프로그래밍.풀어야할문제.RGB거리_1149_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        int[][] cost = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            cost[i][RED] = Integer.parseInt(s[0]);
            cost[i][GREEN] = Integer.parseInt(s[1]);
            cost[i][BLUE] = Integer.parseInt(s[2]);
        }

        for (int i = 1; i <= n; i++) {
            dp[i][RED] = cost[i][RED] + Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
            dp[i][GREEN] = cost[i][GREEN] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
            dp[i][BLUE] = cost[i][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
        }
        System.out.println(Math.min(dp[n][RED], Math.min(dp[n][GREEN], dp[n][BLUE])));
    }
}
