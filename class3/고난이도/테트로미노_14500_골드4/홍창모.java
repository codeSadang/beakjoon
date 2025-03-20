package class3.고난이도.테트로미노_14500_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static int[][] BOARD;
    static boolean[][] VISITED;

    static int[] DX = {0, -1, 0, 1};
    static int[] DY = {-1, 0, 1, 0};

    static int ANSWER = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new int[N][M];
        VISITED = new boolean[N][M];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < M; j++ ) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < M; j++ ) {
                VISITED[i][j] = true;
                dfs(i, j, 0, 0);
                VISITED[i][j] = false;

                ANSWER = Math.max(ANSWER, checkT(i, j));
            }
        }

        System.out.print(ANSWER);
    }

    public static void dfs(int x, int y, int depth, int sum) {
        if( depth == 4 ) {
            ANSWER = Math.max(ANSWER, sum);
            return;
        }

        for( int i = 0; i < 4; i++ ) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if( nx < 0 || ny < 0 || nx >= N || ny >= M || VISITED[nx][ny] ) continue;

            VISITED[nx][ny] = true;
            dfs(nx, ny, depth+1, sum+BOARD[nx][ny]);
            VISITED[nx][ny] = false;
        }
    }

    public static int checkT(int x, int y) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for( int i = 0; i < 4; i++ ) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;

            sum += BOARD[nx][ny];
            min = Math.min(min, BOARD[nx][ny]);
        }

        if( min != Integer.MAX_VALUE ) {
            return sum + BOARD[x][y] - min;
        }

        return 0;
    }
}
