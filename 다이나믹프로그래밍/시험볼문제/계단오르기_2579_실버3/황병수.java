package 다이나믹프로그래밍.시험볼문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
 *  각 계단에는 점수가 쓰여있는데 해당 계단을 밟으면 점수를 얻게됨
 *  --
 *  단, 규칙이 있는데
 *  한번에 한계단 또는 두계단씩 오를 수 있다.
 *  한 계단을 밟으면서 이어서 다음계단이나 다다음 계단으로 오를 수 있다.
 *  --
 *  1. 연속된 3개의 계단을 모두 밟을 수 없고,
 *  2. 시작점은 계단에 포함되지 않는다.
 *  3. 마지막 도착 계단은 반드시 밟아야 한다.
 *  4. 계단의 개수는 300 이하의 자연수
 *  5. 계단의 점수는 10,000 이하의 자연수
 *  --
 *  최종적으로 최대값을 구하려고 한다.
 */
public class 황병수 {

    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        stairs = new int[testCase+1];
        dp = new int[testCase+1];


        for (int i = 1; i <= testCase; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];

        if( testCase >= 2 ) {
            dp[2] = stairs[1] + stairs[2];
        }


        for (int i = 3; i <= testCase; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[testCase]);
    }
}
