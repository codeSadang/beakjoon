package 다이나믹프로그래밍.시험볼문제.일로만들기_1463_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3으로 나누어 떨어지면 3으로 나누고
 * 2로 나누어 떨어지면 2로 나누고
 * 그렇지 않으면 1을 뺸다.
 */
public class 황병수 {

    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int InputValue = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 5000);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= InputValue; i++) {
            if (i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if (i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (dp[i-1] < 5000) dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        System.out.println(dp[InputValue]);
    }
}
