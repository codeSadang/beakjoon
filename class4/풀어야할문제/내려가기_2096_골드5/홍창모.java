package class4.풀어야할문제.내려가기_2096_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][3];

        StringTokenizer st;

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 0; j < 3; j++ ) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        for( int i = 0; i < 3; i++ ) {
            dp[0][i] = map[0][i];
        }

        for( int i = 1; i < N; i++ ) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + map[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }

        int max = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));

        for( int i = 1; i < N; i++ ) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }


        int min = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

        sb.append(max).append(" ").append(min);

        System.out.print(sb);
    }
}
