package class3.풀어야할문제.마인크래프트_18111_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  우선
 */
public class 황병수 {

    static int[][] map;
    static int TotalCnt, TotalFloor;
    static int MinFloor = Integer.MAX_VALUE;
    static int MaxFloor = Integer.MIN_VALUE;
    static int N,M,B;

    static int[] result = {Integer.MAX_VALUE, 0}; // 초기값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        TotalFloor = 0;
        TotalCnt = N * M;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                MaxFloor = Math.max(MaxFloor, map[i][j]);
                MinFloor = Math.min(MinFloor, map[i][j]);
                TotalFloor += map[i][j];
            }
        }

        for (int value = MinFloor; value <= MaxFloor; value++) {
            calcTime(value);
        }

        System.out.println(result[0] + " " + result[1]);
    }

    private static void calcTime(int targetFloor) {
        int needTotalCnt = targetFloor * TotalCnt;
        int needTime = 0;

        // 최소 블럭 조건
        if (TotalFloor + B >= needTotalCnt) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (map[i][j] > targetFloor) {
                        needTime += (2 * (map[i][j] - targetFloor));
                    } else if (map[i][j] < targetFloor) {
                        needTime += (targetFloor - map[i][j]);
                    }
                }
            }

            // 최소 시간 갱신 및 같은 시간일 경우 높은 층 선택
            if (needTime < result[0] || (needTime == result[0] && targetFloor > result[1])) {
                result[0] = needTime;
                result[1] = targetFloor;
            }
        }
    }
}
