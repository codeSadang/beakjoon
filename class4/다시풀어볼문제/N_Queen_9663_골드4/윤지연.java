package class4.다시풀어볼문제.N_Queen_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        placeQueen(0);
        System.out.println(count);
    }

    static void placeQueen(int col) {
        // 기저 조건
        if (col == N) {
            count++;
            return;
        }

        // 열마다 해야 할 작업
        for (int i = 0; i < N; i++) {
            board[col] = i; // 예, 3번째 열의 i 행에 퀸 배치
            if (isValid(col)) { // 앞서 놓은 배치가 유효하면 그 다음 열에 퀸 배치
                placeQueen(col + 1);
            }
        }
    }

    static boolean isValid(int col) {
        // 같은 행, 대각선에 있는지 확인 // 이전에 배치한 모든 퀸과 비교
        for ( int i = 0; i < col; i++) {
            // 만약 board[i]가 board[col]과 같다면 거짓 반환
            if (board[i] == board[col]) return false;
            // 대각선 확인 (행 차이 == 열 차이)
            if (Math.abs(board[i] - board[col]) == Math.abs(i - col)) return false;
        }
        return true;
    }
}
