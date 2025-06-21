package 백트래킹.풀어야할문제.NQUEEN_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {
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
        System.out.println("result = " + result);
    }

    static void dfs(int y, int x, int cardCnt) {

        if (cardCnt == N) {
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    checkPosition(ny,nx);

                    dfs(ny,nx,cardCnt + 1);

                    visited[ny][nx] = false;
                    unCheckPosition(ny,nx);
                }
            }
        }


    }

    static void checkPosition(int y, int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (y-x == i-j || i == y || j == x) {
                    visited[i][j] = true;
                }
            }
        }
    }

    static void unCheckPosition(int y, int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (y-x == i-j || i == y || j == x) {
                    visited[i][j] = false;
                }
            }
        }
    }
}
