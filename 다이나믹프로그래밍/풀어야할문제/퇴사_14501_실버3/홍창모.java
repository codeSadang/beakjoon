package 다이나믹프로그래밍.풀어야할문제.퇴사_14501_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;

    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // N+5로 선언하는 이유는 T는 5일 까지이기 때문.
        dp = new int[N+5][2];

        for( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            dp[i][0] = T;
            dp[i][1] = P;
        }

        int max = 0;

        for( int i = N; i > 0; i-- ) {
            int day = i + dp[i][0];

            if( day <= N+1 ) {
                dp[i][1] += dp[day][1];
                max = Math.max(max, dp[i][1]);
            } else {
                dp[i][1] = 0;
            }

            dp[i][1] = Math.max(max, dp[i][1]);
        }

        System.out.println(max);

    }
}
