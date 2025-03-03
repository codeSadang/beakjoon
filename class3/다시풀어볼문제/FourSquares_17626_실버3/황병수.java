package class3.다시풀어볼문제.FourSquares_17626_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 라그랑주는 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현
 * 26은 5의 2승 & 1의 2승 의 합 or 4^2 + 3^2 + 1^2 으로 표현
 */
public class 황병수 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 큰 값으로 초기화
        dp[0] = 0; // 0은 0개

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
