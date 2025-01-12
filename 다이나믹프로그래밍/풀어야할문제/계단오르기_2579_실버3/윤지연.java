package 다이나믹프로그래밍.풀어야할문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    /*
    필수 포함 - 시작점, 도착점
    시작점 - 1번 또는 2번
    최대값이 되기 위해 많은 계단을 밟는 것이 유리함
    계단 밝기 여부
    - 직전에 밝고 현재 밟고
    - 전전에 밟고 현재 밟고
    * */

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        // dp[i][0]: 직전 계단 밟지 않음
        // dp[i][1]: 전전 계단 밟지 않고, 직전 계단 밟음
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = stairs[1];
        dp[1][1] = stairs[1];

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i]; //
                dp[i][1] = dp[i - 1][0] + stairs[i]; // 전전 계단을 무조건 밟지 않아야함
            }
        }
        int answer = Math.max(dp[n][0], dp[n][1]);
        System.out.println(answer);
    }
}
