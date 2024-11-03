package 백트래킹.완료된문제.넴모넴모_14712_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {

    static int N;
    static int M;
    static boolean[][] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // 1. 입력처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];

        backtrack(0);

        System.out.println(count);
    }

    // 2. 넴모 놓기
    public static void backtrack(int idx) {
        if (idx == N * M) {
            if (isValid()) {
                count++;
            }
            return;
        }

        int row = idx / M;
        int col = idx % M;

        // 넴모 놓지 않는 경우
        backtrack(idx + 1);

        // 넴모 놓는 경우
        board[row][col] = true;
        backtrack(idx + 1);

        // 원상복구
        board[row][col] = false;
    }

    // 3. 유효성 검사(2 * 2 사각형 만들어졌나)
    public static boolean isValid() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
