package class4.풀어야할문제.파이프옮기기1_17070_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {

    static int N;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,1,0);

        System.out.println(count);
    }

    static void dfs(int x, int y, int direction) {
        // 재귀 종료 조건
        if (x >= N || y >= N) {
            return;
        }

        if (map[x][y] == 1) {
            return;
        }

        if (direction == 2) {
            if (x-1 < 0 || y-1 < 0 || map[x-1][y] == 1 || map[x][y-1] == 1) {
                return;
            }
        }

        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }

        switch (direction) {
            case 0: // 가로 상태일 때
                if (y + 1 < N && map[x][y + 1] == 0) { // 가로 이동
                    dfs(x, y + 1, 0);
                }
                if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0
                        && map[x][y + 1] == 0 && map[x + 1][y] == 0) { // 대각선 이동
                    dfs(x + 1, y + 1, 2);
                }
                break;

            case 1: // 세로 상태일 때
                if (x + 1 < N && map[x + 1][y] == 0) { // 세로 이동
                    dfs(x + 1, y, 1);
                }
                if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0
                        && map[x][y + 1] == 0 && map[x + 1][y] == 0) { // 대각선 이동
                    dfs(x + 1, y + 1, 2);
                }
                break;

            case 2: // 대각 상태일 때
                if (y + 1 < N && map[x][y + 1] == 0) { // 가로 이동
                    dfs(x, y + 1, 0);
                }
                if (x + 1 < N && map[x + 1][y] == 0) { // 세로 이동
                    dfs(x + 1, y, 1);
                }
                if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0
                        && map[x][y + 1] == 0 && map[x + 1][y] == 0) { // 대각선 이동
                    dfs(x + 1, y + 1, 2);
                }
                break;
        }
    }
}
