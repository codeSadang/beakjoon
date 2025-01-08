package 다이나믹프로그래밍.풀어야할문제.평범한배낭_12865_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모2 {

    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 물품의 수
        K = Integer.parseInt(st.nextToken());       // 버틸 수 있는 무게

        // 버틸 수 있는 무게 (1~K 까지 가치를 0으로 초기화)
        int[] dp = new int[K+1];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            // 물건의 무게
            int weight = Integer.parseInt(st.nextToken());
            // 물건의 가치
            int value = Integer.parseInt(st.nextToken());

            for( int j = K; j >= weight; j-- ) {
                // 버틸 수 있는 최대 무게부터 물건의 무게까지 역순으로 반복
                dp[j] = Math.max( dp[j], dp[j-weight] + value );
            }
        }

        System.out.println(dp[K]);

    }
}
