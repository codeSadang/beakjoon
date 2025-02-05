package 다이나믹프로그래밍.시험볼문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 설탕의 무게
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        for( int i = 1; i <= N; i++ ) {
            dp[i] = 5000;

            if( i >= 3 ) dp[i] = Math.min(dp[i], dp[i-3] + 1);
            if( i >= 5 ) dp[i] = Math.min(dp[i], dp[i-5] + 1);
        }

        if( dp[N] == 5000 ) System.out.print(-1);
        else System.out.print(dp[N]);
    }
}
