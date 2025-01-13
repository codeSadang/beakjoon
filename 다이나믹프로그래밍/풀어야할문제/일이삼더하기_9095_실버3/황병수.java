package 다이나믹프로그래밍.풀어야할문제.일이삼더하기_9095_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int nowNum = Integer.parseInt(br.readLine());

            int[] dp = new int[nowNum + 1];

            dp[0] = 1;

            for (int j = 1; j <= nowNum; j++) {
                if (j - 1 >= 0) dp[j] += dp[j-1];
                if (j - 2 >= 0) dp[j] += dp[j-2];
                if (j - 3 >= 0) dp[j] += dp[j-3];
            }

            System.out.println(dp[nowNum]);
        }
    }
}
