package 다이나믹프로그래밍.풀어야할문제.다리놓기_1010_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int T;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        dp = new int[31][31];

        for( int i = 0; i < T; i++ ) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combination(M, N)).append("\n");
        }

        System.out.print(sb);
    }

    private static int combination(int n, int m) {
        if( dp[n][m] != 0 ) return dp[n][m];
        if( n == m || m == 0 ) return dp[n][m] = 1;
        return dp[n][m] = combination(n-1, m-1) + combination(n-1, m);
    }
}
