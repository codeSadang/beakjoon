package 다이나믹프로그래밍.풀어야할문제.계단오르기_2579_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 * 마지막 도착 계단은 반드시 밟아야 한다.
 * */
public class 홍창모 {

    static int N;

    static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 계단의 개수
         stairs = new int[N+1]; // 계단의 점수

        for( int i = 1; i <= N; i++ ) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];

        dp[1] = stairs[1];

        if( N >= 2 ) {
            dp[2] = stairs[1] + stairs[2];
        }

        for( int i = 3; i <= N; i++ ) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[N]);
    }
}
