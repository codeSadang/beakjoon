package 백트래킹.완료된문제.넴모넴모_14712_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static boolean[][] VISITED;
    public static int RESULT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        VISITED = new boolean[N][M];

        // 백트래킹 시작 (0번째 칸부터)
        backtracking(0, 0);

        System.out.println(RESULT);
    }

    private static void backtracking(int row, int col) {
        // 마지막 열을 넘으면 다음 행으로 이동
        if (col == M) {
            row++;
            col = 0;
        }

        // 마지막 행까지 탐색이 끝난 경우, 배치가 가능하므로 카운트를 증가
        if (row == N) {
            RESULT++;
            return;
        }

        // 해당 칸에 넴모를 놓지 않는 경우
        backtracking(row, col + 1);

        // 해당 칸에 넴모를 놓는 경우
        // 2x2 크기의 사각형이 만들어지는지 확인
        if (canPlaceNemo(row, col)) {
            VISITED[row][col] = true;  // 넴모를 놓음
            backtracking(row, col + 1);  // 다음 칸으로 이동
            VISITED[row][col] = false;  // 넴모를 다시 제거 (백트래킹)
        }
    }

    /****
     * Determines whether a Nemo piece can be placed at the specified cell without forming a 2x2 block of placed pieces.
     *
     * @param row the row index of the cell to check
     * @param col the column index of the cell to check
     * @return true if placing a Nemo at (row, col) does not create a 2x2 square of placed pieces; false otherwise
     */
    public static boolean canPlaceNemo(int row, int col) {
        // 2x2 사각형을 만들 수 없는 위치인 경우 true를 반환(즉, 넴모를 놓을 수 있음)
        if (row == 0 || col == 0) {
            return true;
        }

        // 2x2 사각형이 이미 있는지 확인
        if (VISITED[row - 1][col - 1] && VISITED[row - 1][col] && VISITED[row][col - 1]) {
            return false;  // 2x2 사각형이 만들어지면 넴모를 놓을 수 없음
        }

        return true;  // 2x2 사각형이 없으면 넴모를 놓을 수 있음
    }

}