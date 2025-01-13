package 다이나믹프로그래밍.풀어야할문제.피보나치함수_1003_실버3;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {
    
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 2; j <= n; j++ ) {
                dp[j][0] = dp[j - 2][0] + dp[j - 1][0];
                dp[j][1] = dp[j - 2][1] + dp[j - 1][1];
            }
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
