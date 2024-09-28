package 깊이우선탐색.풀어야할문제.유기농배추_1012_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int[][] farm; // 배추밭
    static boolean[][] visited; // 방문여부
    static int M,N,K; // 가로, 세로, 배추개수
    static int[] dx = {0,0,-1,1}; // 상하좌우 이동
    static int[] dy = {-1,1,0,0}; // 상하좌우 이동

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            farm = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            int count = 0; // 보호받는 배추 그룹 수

            // 모든 좌표 검색

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(farm[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true; // 현재 좌표 방문 처리

        // 상하좌우로 인접한 배추 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i]; // 새로운 y 좌표
            int nx = x + dx[i]; // 새로운 x 좌표

            // 배추밭의 범위를 벗어나지 않고, 배추가 심어져 있으며, 방문하지 않은 곳
            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (farm[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx); // 인접한 배추로 이동하여 재귀적으로 탐색
                }
            }
        }
    }
}

