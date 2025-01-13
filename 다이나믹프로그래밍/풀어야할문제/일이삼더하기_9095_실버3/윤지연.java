package 다이나믹프로그래밍.풀어야할문제.일이삼더하기_9095_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] == 0) {
                dp[n] = solve(n);
            }
            answer.append(dp[n]).append("\n");
        }
        System.out.println(answer);
    }

    static int solve(int n) {
        if (n < 4) {
            return dp[n];
        }
        dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
        return dp[n];
    }
}
