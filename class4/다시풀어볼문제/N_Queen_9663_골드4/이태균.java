package class4.다시풀어볼문제.N_Queen_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    static int N;
    static int[] COL; // 행에서 퀸이 위치한 열
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        COL = new int[N + 1];

        // 첫 번째 행부터 시작
        nQueen(1);

        System.out.println(COUNT);
    }

    // 행을 기준으로 퀸을 놓는 함수
    private static void nQueen(int col) {
        // 모든 행에 퀸을 놓았다면 카운트 증가
        if (col > N) {
            COUNT++;
            return;
        }

        // 현재 행에서 각 열에 퀸을 놓는 시도
        for (int i = 1; i <= N; i++) {
            COL[col] = i;

            // 이전까지 놓은 퀸들과 충돌하지 않는지 검사
            if (validate(col)) {
                nQueen(col + 1);
            }
        }
    }

    // 이전에 놓은 퀸들과 충돌하는지 검사하는 함수
    private static boolean validate(int col) {
        // 1행부터 현재 행 이전까지 검사
        for (int i = 1; i < col; i++) {
            // 같은 열에 있는 경우
            if (COL[i] == COL[col]) {
                return false;
            }

            // |col[i] - col[row]|: 열의 차이
            // |i - row|: 행의 차이
            // 열의 차이와 행의 차이가 같으면 대각선 상에 있음
            if (Math.abs(COL[i] - COL[col]) == Math.abs(i - col)) {
                return false;
            }
        }

        return true;
    }

}