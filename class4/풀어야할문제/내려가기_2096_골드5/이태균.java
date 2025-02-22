package class4.풀어야할문제.내려가기_2096_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[][] GAME_BOARD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        GAME_BOARD = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                GAME_BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[2][3];

        for (int i = 0; i < N; i++) {
            int max0 = result[0][0];
            int min0 = result[1][0];
            int max1 = result[0][1];
            int min1 = result[1][1];
            int max2 = result[0][2];
            int min2 = result[1][2];

            result[0][0] = Math.max(max0, max1) + GAME_BOARD[i][0];
            result[0][1] = Math.max(Math.max(max0, max1), max2) + GAME_BOARD[i][1];
            result[0][2] = Math.max(max1, max2) + GAME_BOARD[i][2];

            result[1][0] = Math.min(min0, min1) + GAME_BOARD[i][0];
            result[1][1] = Math.min(Math.min(min0, min1), min2) + GAME_BOARD[i][1];
            result[1][2] = Math.min(min1, min2) + GAME_BOARD[i][2];
        }

        int max = Arrays.stream(result[0]).max().getAsInt();
        int min = Arrays.stream(result[1]).min().getAsInt();
        sb.append(max).append(" ").append(min);

        System.out.println(sb);
    }
    
}