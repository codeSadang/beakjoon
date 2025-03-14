package class3.고난이도.테트로미노_14500_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {
    static int N, M, max = 0;
    static int[][] map;
    static boolean[][] visited;

    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;

                // ‘ㅜ’ 모양 따로 체크
                checkTShape(i, j);
            }
        }

        System.out.println(max);
    }

    // DFS 탐색 (4칸 선택)
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) { // 4칸 선택 완료
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // ‘ㅜ’ 모양 체크 (DFS로 탐색 불가능하므로 직접 계산)
    private static void checkTShape(int x, int y) {
        // ‘ㅜ’ 모양은 네 방향으로 검사
        int[][] dxT = {{0, 0, 1, -1}, {0, 1, 1, 1}, {0, 0, -1, 1}, {0, -1, -1, -1}};
        int[][] dyT = {{0, 1, -1, 0}, {0, -1, 0, 1}, {0, 1, 0, -1}, {0, -1, 0, 1}};

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean isValid = true;
            for (int j = 0; j < 4; j++) {
                int nx = x + dxT[i][j];
                int ny = y + dyT[i][j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }
                sum += map[nx][ny];
            }
            if (isValid) max = Math.max(max, sum);
        }
    }
}