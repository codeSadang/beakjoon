package 다이나믹프로그래밍.풀어야할문제.일이삼더하기_9095_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();



        // 테스트 케이스의 개수
        T = Integer.parseInt(br.readLine());

        for( int i = 0; i < T; i++ ) {
            int num = Integer.parseInt(br.readLine());

            // 1, 2, 3을 더해서 num을 만드는 방법의 수
            int[] dp = new int[num+1];

            dp[0] = 1;

            for( int j = 1; j <= num; j++ ) {
                if( j - 1 >= 0 ) dp[j] += dp[j-1];
                if( j - 2 >= 0 ) dp[j] += dp[j-2];
                if( j - 3 >= 0 ) dp[j] += dp[j-3];
            }

            sb.append(dp[num]).append("\n");
        }

        System.out.print(sb);

    }
}
