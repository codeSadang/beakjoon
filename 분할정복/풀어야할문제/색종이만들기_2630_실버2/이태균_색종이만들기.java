package 분할정복.풀어야할문제.색종이만들기_2630_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균_색종이만들기 {

    public static int N;
    public static int[][] CONFETTI;
    public static int[] RESULT = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        CONFETTI = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                CONFETTI[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int color : RESULT) {
            System.out.println(color);
        }
    }

    public static void divide(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            if (CONFETTI[row][col] == 0) {
                RESULT[0]++;
            } else {
                RESULT[1]++;
            }
            return;
        }

        divide(row, col, size / 2);
        divide(row, col + (size / 2), size / 2);
        divide(row + (size / 2), col, size / 2);
        divide(row + (size / 2), col + (size / 2), size / 2);
    }

    public static boolean checkColor(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (CONFETTI[i][j] != CONFETTI[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

}