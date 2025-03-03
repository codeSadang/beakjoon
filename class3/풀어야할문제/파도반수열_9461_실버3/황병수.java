package class3.풀어야할문제.파도반수열_9461_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class 황병수 {

    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 기저 조건 초기화
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(getDp(N)).append('\n');
        }

        System.out.println(sb);
    }

    private static long getDp(int index) {
        if (dp[index] != 0L) {
            return dp[index];
        } else {
            dp[index] = getDp(index - 2) + getDp(index - 3);
            return dp[index];
        }
    }
}
