package 다이나믹프로그래밍.풀어야할문제.평범한배낭_12865_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, K;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 무게만큼의 배열을 선언
        dp = new int[K+1];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            // 물건의 무게
            int weight = Integer.parseInt(st.nextToken());
            // 물건의 가치
            int value = Integer.parseInt(st.nextToken());

            // 최대무게부터 물건의 무게만큼의 반복문
            for( int j = K; j >= weight; j-- ) {
                dp[j] = Math.max( dp[j], dp[j-weight] + value );
            }
        }

        System.out.print(dp[K]);
    }
}
