package 다이나믹프로그래밍.풀어야할문제.다리놓기_1010_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][m + 1];

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= Math.min(i, n); k++) {
                    if (k == 0 || j == k) {
                        dp[j][k] = 1;
                    } else {
                        dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                    }
                }
            }
        }
    }

}