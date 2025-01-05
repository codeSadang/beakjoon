package 다이나믹프로그래밍.풀어야할문제.평범한배낭_12865_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[][] arr = new int[N+1][2];
        // arr[i][j] = 무게 i의 가치 j
        for (int i = 1; i <= N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        int[][] dp = new int[N+1][K+1];
        // dp 배열
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (arr[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
