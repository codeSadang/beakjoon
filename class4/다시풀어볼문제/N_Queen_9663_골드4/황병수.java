package class4.다시풀어볼문제.N_Queen_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static int N;
    static int[][] board; // N x N 체스판
    static int solutions = 0; // 가능한 정답 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        solve(0); // 0번째 행부터 시작
        System.out.println(solutions);
    }

    private static void solve(int row) {
        if (row == N) { // 모든 행에 퀸을 배치 완료
            solutions++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) { // 현재 위치에 퀸을 배치 가능하면
                board[row][col] = 1; // 퀸 배치
                solve(row + 1); // 다음 행으로 이동
                board[row][col] = 0; // 백트래킹 (되돌리기)
            }
        }
    }

    static boolean isSafe(int row, int col) {
        // 1. 같은 열(col)에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // 2. 왼쪽 위 대각선(↖) 확인
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // 3. 오른쪽 위 대각선(↗) 확인
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true; // 퀸을 배치할 수 있음
    }
}
