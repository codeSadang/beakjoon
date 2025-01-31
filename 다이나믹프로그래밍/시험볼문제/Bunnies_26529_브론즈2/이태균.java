package 다이나믹프로그래밍.시험볼문제.Bunnies_26529_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0 || x == 1) {
                sb.append(1).append("\n");
                continue;
            }

            int[] dp = new int[x + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int j = 2; j <= x; j++) {
                dp[j] = dp[j - 2] + dp[j - 1];
            }

            sb.append(dp[x]).append("\n");
        }

        System.out.println(sb);
    }

}