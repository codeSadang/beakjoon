package 다이나믹프로그래밍.풀어야할문제.포도주시식_2156_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }

        if (n == 2) {
            System.out.println(wine[0] + wine[1]);
            return;
        }

        int[] dp = new int[n];

        // 0, 1번째 인덱스 값 채워주고
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];

        // 2번째 인덱스에서 규칙을 찾은 후에 => 점화식 생성
        dp[2] = Math.max(wine[0] + wine[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i] + wine[i - 1]));
        }

        System.out.println(dp[n - 1]);
    }

}