package 백트래킹.풀어야할문제.NQUEEN_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static int N;
    static int[][] queen;
    static int result = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1 ,0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N][N];
        visited = new boolean[N][N];

        dfs(0,0, 0);

    }

    static void dfs(int y, int x, int cardCnt) {
        if (cardCnt == N) {
            result++;
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
               visited[ny][nx] = true;
            }
        }


    }
}
