package class3.풀어야할문제.타일링2_11727_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1X2. 2x1 2x2 로 채우는 방법의 수를 구하라
 */
public class 황병수 {

    static int N;
    static int[] Dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Dp = new int[N+1];

        Dp[1] = 1;
        Dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            Dp[i] +=  (Dp[i-1] + Dp[i-2] * 2) % 10007;
        }

        System.out.println(Dp[N]);
    }
}
