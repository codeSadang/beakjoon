package 깊이우선탐색.풀어야할문제.내리막길_1520_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS, 메모이제이션 사용
 */
public class 황병수 {
    static int[][] matrix;
    static int column, row;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 할당
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        // 값 초기화
        matrix = new int[row][column];
        dp = new int[row][column];

        // matrix 값 추가
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  // -1로 초기화하여 미방문 상태 표시
            }
        }



        System.out.println(dfs(0,0));
    }

    static int dfs(int y, int x) {
        // 도착 지점에 도달한 경우
        if (y == row - 1 && x == column - 1) {
            return 1;
        }

        // 이미 방문한 적이 있는 경우 바로 반환
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;  // 현재 위치에서 시작 경로 수 0으로 초기화

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && ny >= 0 && nx < column && ny < row) {
                if (matrix[ny][nx] < matrix[y][x]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }

        return dp[y][x];
    }
}
