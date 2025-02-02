package 다이나믹프로그래밍.시험볼문제.Bunnies_26529_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    static int[] dp = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 45; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(dp[temp]);
        }
    }

    // 재귀
    private static int solve(int x) {
        if (x < 2) {
            return dp[x];
        }
        if (dp[x] == 0) {
            dp[x] = solve(x - 1) + solve(x - 2);
        }
        return dp[x];
    }
}
