package 다이나믹프로그래밍.풀어야할문제.일이삼더하기_9095_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 4를 1 2 3 의 합으로 나타내는 방법
 * 합을 나타낼 때에는 수를 1개이상 사용해야 함
 */
public class 황병수 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int testCase = Integer.parseInt(br.readLine());

            int[] dp = new int[testCase + 1];

            dp[0] = 1;

            for (int j = 1; j <= testCase; j++) {
                if (j-1 >= 0) dp[j] += dp[j-1];
                if (j-2 >= 0) dp[j] += dp[j-2];
                if (j-3 >= 0) dp[j] += dp[j-3];
            }

            sb.append(dp[testCase]).append('\n');
        }

        System.out.println(sb);
    }
}
