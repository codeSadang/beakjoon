package 깊이우선탐색.풀어야할문제.적록색약_10026_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 황병수 {
    static boolean[][] visited;         // 방문 여부 배열
    static boolean[][] visitedAbnormal; // 색약 시나리오 방문 여부 배열
    static String[][] draw;             // 색칠된 그림
    static int[] dx = {-1, 0, 1, 0};    // 상하좌우 방향 배열
    static int[] dy = {0, 1, 0, -1};    // 상하좌우 방향 배열
    static int size = 0;
    static HashMap<String, Integer> normalColorCount;  // 정상 시나리오 카운트
    static HashMap<String, Integer> abnormalColorCount; // 색약 시나리오 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());

        // 초기화
        visited = new boolean[size][size];
        visitedAbnormal = new boolean[size][size]; // 색약 시나리오 방문 여부 배열
        draw = new String[size][size];
        normalColorCount = new HashMap<>();
        abnormalColorCount = new HashMap<>();

        // 값 할당
        for (int i = 0; i < size; i++) {
            draw[i] = bf.readLine().split("");
        }

        // 색깔 구역 탐색
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // 정상 시나리오 처리
                if (!visited[i][j]) {
                    String color = draw[i][j];
                    dfs(i, j, color); // 정상 시나리오
                    normalColorCount.put(color, normalColorCount.getOrDefault(color, 0) + 1);
                }

                // 색약 시나리오 처리
                if (!visitedAbnormal[i][j]) {
                    String color = draw[i][j];
                    if ("R".equals(color) || "G".equals(color)) {
                        color = "R";
                    }
                    dfsAbnormal(i, j, color); // 색약 시나리오
                    abnormalColorCount.put(color, abnormalColorCount.getOrDefault(color, 0) + 1); // R, G를 동일하게 처리
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(normalColorCount.values().stream().mapToInt(Integer::intValue).sum());
        sb.append(" ");
        sb.append(abnormalColorCount.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println(sb);
    }

    // 정상 DFS 메서드
    static void dfs(int x, int y, String color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visited[nx][ny]) {
                String nextColor = draw[nx][ny];
                if (nextColor.equals(color)) {
                    dfs(nx, ny, color);
                }
            }
        }
    }

    // 색약 DFS 메서드
    static void dfsAbnormal(int x, int y, String color) {
        visitedAbnormal[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visitedAbnormal[nx][ny]) {
                String nextColor = draw[nx][ny];
                // 색약 처리 (R, G를 동일하게 처리)
                if ("R".equals(nextColor) || "G".equals(nextColor)) {
                    nextColor = "R";
                }

                if (nextColor.equals(color)) {
                    dfsAbnormal(nx, ny, color);
                }
            }
        }
    }
}
