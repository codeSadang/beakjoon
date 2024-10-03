package 깊이우선탐색.풀어야할문제.섬의개수_4963_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 황병수 {

    static int width;
    static int height;
    static int[][] land; // 땅
    static boolean[][] visited; // 방문여부
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if (width == 0 && height == 0) break; // 종료 조건

            land = new int[height][width]; // 지도 초기화
            visited = new boolean[height][width]; // 방문 배열 초기화

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            // 지도 전체 탐색
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // 땅이 있고 방문하지 않은 곳이라면 DFS 실행
                    if (land[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // DFS로 연결된 섬 탐색
                        count++; // 섬 개수 증가
                    }
                }
            }

            sb.append(count).append("\n"); // 섬의 개수를 출력에 추가
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y) {

        visited[x][y] = true; // 현재 위치 방문 처리

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도의 범위를 벗어나지 않으며, 땅이고 방문하지 않은 곳이면 탐색
            if (nx >= 0 && ny >= 0 && nx < height && ny < width) {
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 재귀적으로 연결된 땅 탐색
                }
            }
        }
    }
}
