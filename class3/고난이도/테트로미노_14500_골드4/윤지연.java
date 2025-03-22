package class3.고난이도.테트로미노_14500_골드4;

import java.util.*;
import java.io.*;

public class 윤지연 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 셀을 시작점으로 DFS 및 T모양 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
                checkT(i, j);
            }
        }
        System.out.println(answer);
    }

    // DFS를 이용하여 4칸 연결 모양의 합 계산
    public static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + board[nx][ny], count + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // 'ㅗ' 모양을 따로 처리하는 함수
    public static void checkT(int x, int y) {
        int center = board[x][y];
        int count = 0;
        int sum = center;
        int min = Integer.MAX_VALUE;
        // 상하좌우 4방향 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            count++;
            sum += board[nx][ny];
            min = Math.min(min, board[nx][ny]);
        }
        // T 모양은 중심을 기준으로 3개 이상의 방향이 있어야 가능
        if (count < 3) return;
        // 4방향 모두 있다면 가장 작은 값 하나를 제외하여 T 모양 완성
        if (count == 4) {
            sum -= min;
        }
        answer = Math.max(answer, sum);
    }
}

