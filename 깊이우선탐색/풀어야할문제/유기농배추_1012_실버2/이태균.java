package 깊이우선탐색.풀어야할문제.유기농배추_1012_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int M;
    public static int N;
    public static int K;

    public static int[][] FARM;
    public static boolean[][] VISITED;

    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 배추밭 크기 셋팅
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            FARM = new int[M][N];
            VISITED = new boolean[M][N];

            // 배추가 심어진 위치 개수
            K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                FARM[x][y] = 1;
            }

            int count = 0;
            for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    if (FARM[y][x] == 1 && !VISITED[y][x]) {
                        dfs(y, x);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int y, int x) {
        // 현재 배추 방문
        VISITED[y][x] = true;

        // 상하좌우로 배추를 탐색
        for (int i = 0; i < 4; i++) {
            int c_y = y + DY[i];
            int c_x = x + DX[i];

            // 1. 배추밭에서만 확인 2. 방문하지 않은 곳
            if (c_y >= 0 && c_y < M && c_x >= 0 && c_x < N) {
                if (FARM[c_y][c_x] == 1 && !VISITED[c_y][c_x]) {
                    // 상하좌우로 방문한 배추로 이동해서 탐색
                    dfs(c_y, c_x);
                }
            }
        }
    }

}