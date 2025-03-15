package class3.고난이도.테트로미노_14500_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[][] BOARD;
    public static boolean[][] VISITED;

    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new int[N][M];
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                VISITED[i][j] = true;
                backtracking(i, j, 0, 0);
                VISITED[i][j] = false;
            }
        }

        System.out.println(MAX);
    }

    private static void backtracking(int nowRow, int nowCol, int size, int sum) {
        if (size == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = nowRow + DX[i];
            int nextCol = nowCol + DY[i];

            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                continue;
            }

            if (!VISITED[nextRow][nextCol]) {
                if (size == 2) {
                    VISITED[nextRow][nextCol] = true;
                    backtracking(nowRow, nowCol, size + 1, sum + BOARD[nextRow][nextCol]);
                    VISITED[nextRow][nextCol] = false;
                }

                VISITED[nextRow][nextCol] = true;
                backtracking(nextRow, nextCol, size + 1, sum + BOARD[nextRow][nextCol]);
                VISITED[nextRow][nextCol] = false;
            }
        }
    }

    public static void T(int nowRow, int nowCol) {

    }

}