package 다이나믹프로그래밍.시험볼문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;

    static int[] stairs, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단의 개수
        N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];

        // 계단의 점수
        for( int i = 1; i <=N; i++ ) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N+1];

        dp[1] = stairs[1];

        if( N >= 2 ) {
            dp[2] = stairs[1] + stairs[2];
        }

        for( int i = 3; i <= N; i++ ) {
            dp[i] = Math.max( dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i] );
        }

        System.out.println(dp[N]);

    }
}
