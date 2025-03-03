package class3.풀어야할문제.쉬운최단거리_14940_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 지도가 주어지고 모든 지점에 대해서 목표지점까지의 거리를 구하라
 * 가로 세로만 이동 가능
 *
 * n 세로
 * m 가로
 * 0은 갈 수 없는 땅
 * 1은 갈 수 있는 땅
 * 2는 목표지점
 */
public class 황병수 {

    static int[][] map;
    static int[][] resultMap;
    static int N,M;
    static int[] startPoint = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        resultMap = new int[N+1][M+1];

        // 값 세팅
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                // 목표 지점 세팅
                if (value == 2) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    resultMap[i][j] = 0; // 시작지점
                }

                if (value == 0) {
                    resultMap[i][j] = 0; // 갈 수 없는 땅은 -1
                } else {
                    resultMap[i][j] = -2; // 방문하지 않은 곳 표시 (-2)
                }
            }
        }

        //출발 지점으로부터 모든 스팟을 계산
        bfs(startPoint[0], startPoint[1]);


        // 출력 처리
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (resultMap[i][j] == -2) {
                    sb.append("-1 ");
                } else {
                    sb.append(resultMap[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int col, int row) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{col, row});
        resultMap[col][row] = 0; // 시작점 거

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowCol = poll[0];
            int nowRow = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextCol = nowCol + dx[i];
                int nextRow = nowRow + dy[i];

                if (nextCol >= 1 && nextCol <= N && nextRow >= 1 && nextRow <= M
                        && map[nextCol][nextRow] == 1 && resultMap[nextCol][nextRow] == -2) {
                    queue.add(new int[]{nextCol, nextRow});
                    resultMap[nextCol][nextRow] = resultMap[nowCol][nowRow] + 1;
                }
            }
        }
    }
}
