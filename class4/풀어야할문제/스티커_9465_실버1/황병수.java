package class4.풀어야할문제.스티커_9465_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int[][] map;
    static boolean[][] visited;
    static int N,M,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 열의 개수

            int[][] sticker = new int[2][N]; // 스티커 점수 저장
            int[][] dp = new int[2][N]; // DP 테이블

            // 스티커 점수 입력
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값 설정 (첫 번째 열)
            dp[0][0] = sticker[0][0]; // 첫 번째 열 위쪽 스티커
            dp[1][0] = sticker[1][0]; // 첫 번째 열 아래쪽 스티커

            if (N > 1) { // 두 번째 열부터 점화식 적용
                dp[0][1] = sticker[0][1] + dp[1][0]; // 두 번째 열 위쪽 선택 시
                dp[1][1] = sticker[1][1] + dp[0][0]; // 두 번째 열 아래쪽 선택 시
            }

            // 점화식 적용 (3번째 열부터 시작)
            for (int j = 2; j < N; j++) {
                dp[0][j] = sticker[0][j] + Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] = sticker[1][j] + Math.max(dp[0][j - 1], dp[0][j - 2]);
            }

            // 최댓값 출력 (마지막 열에서 위쪽/아래쪽 중 더 큰 값 선택)
            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1]));
            sb.append('\n');
        }


        System.out.println(sb);
    }
}
