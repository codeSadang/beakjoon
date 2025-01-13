package 다이나믹프로그래밍.풀어야할문제.RGB거리_1149_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB 거리에는 집에 N개 있다.
 * 거리는 선분으로 나타내고
 * 1번 집부터 N번 집이 순서대로 있다.
 *
 * 빨강 초록 파랑 중 하나의 색으로칠해야 하는데
 * 모든 집을 칠하는 비용의 최소값을 찾기
 *
 * 1번 집의 색은 2번집의 색과 같지 않아야 함
 * N번 집의 색은 N-1의 색과 같지 않아야 한다.
 *
 * i번 집의 색은 i-1 i+1 집의 색과 같지 않아야한다.
 *
 * 매번 색에대한 가격이 다르군!!
 */
public class 황병수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dp = new int[N][3];
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
        }

        int result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(result);
    }
}
