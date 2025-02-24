package class4.풀어야할문제.가장긴증가하는부분수열_11053_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for( int i = 0; i < N; i++ ) {
            dp[i] = 1;

            for( int j = 0; j < i; j++ ) {
                if( A[j] < A[i] ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for( int i = 0; i < N; i++ ) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
