package 다이나믹프로그래밍.풀어야할문제.구간합구하기5_11660_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모2 {

    static int N, M;

    static int[][] board, prefixSumBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2차 배열 초기화
        board = new int[N+1][N+1];
        // 누적합을 담을 2차 배열 초기화
        prefixSumBoard = new int[N+1][N+1];

        // board 값 세팅
        for( int i = 1; i<= N; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 1; j<= N; j++ ) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 배열 세팅
        for( int i = 1; i <= N; i++ ) {
            for( int j = 1; j<=N; j++ ) {
                prefixSumBoard[i][j] = board[i][j] + prefixSumBoard[i-1][j] + prefixSumBoard[i][j-1] - prefixSumBoard[i-1][j-1];
            }
        }

        /*for( int i = 1; i <= N; i++ ) {
            for ( int j = 1; j <= N; j++ ) {
                System.out.print(prefixSumBoard[i][j] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(getSum(x1, y1, x2, y2)).append("\n");
        }

        System.out.print(sb);
    }

    private static int getSum(int x1, int y1, int x2, int y2) {

        return prefixSumBoard[x2][y2] - prefixSumBoard[x1 - 1][y2] - prefixSumBoard[x2][y1-1] + prefixSumBoard[x1-1][y1-1];
    }
}
