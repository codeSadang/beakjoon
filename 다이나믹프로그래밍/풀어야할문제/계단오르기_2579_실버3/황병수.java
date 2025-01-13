package 다이나믹프로그래밍.풀어야할문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
 * 계단을 밟으면 그 점수를 얻게됨
 *
 * 한번에 한계단 또는 두계단 오를 수 있음!!
 * 3번 연속할 수 는 없음
 *
 * 1 2 0
 * 1 0 0
 * 1 0
 */
public class 황병수 {

    static int[] stepList;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stepList = new int[N+1];
        dp = new int[N+1][2];


        for (int i = 1; i <= N; i++) {
            stepList[i] = Integer.parseInt(br.readLine());
        }

        // 전 계단 안밟음
        dp[1][0] = stepList[1];

        // 전전계단 안밟음
        // 전계단 밟음
        dp[1][1] = stepList[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stepList[i];
            dp[i][1] = dp[i-1][0] + stepList[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

    }
}
