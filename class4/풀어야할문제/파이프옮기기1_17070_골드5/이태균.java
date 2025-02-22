package class4.풀어야할문제.파이프옮기기1_17070_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {
    public static int N;
    public static int[][] MAP;
    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(COUNT);
    }

    // status - 0: 가로, 1: 대각선, 2: 세로
    private static void dfs(int row, int col, int status) {
        // 목적지에 도달했을 경우
        if (row == N - 1 && col == N - 1) {
            COUNT++;
            return;
        }

        // 가로 이동
        if (status == 0 || status == 1) {
            if (col + 1 < N && MAP[row][col + 1] != 1) {
                dfs(row, col + 1, 0);
            }
        }

        // 세로 이동
        if (status == 1 || status == 2) {
            if (row + 1 < N && MAP[row + 1][col] != 1) {
                dfs(row + 1, col, 2);
            }
        }

        // 대각선 이동
        if (row + 1 < N && col + 1 < N && MAP[row][col + 1] != 1 && MAP[row + 1][col] != 1 && MAP[row + 1][col + 1] != 1) {
            dfs(row + 1, col + 1, 1);
        }
    }
}