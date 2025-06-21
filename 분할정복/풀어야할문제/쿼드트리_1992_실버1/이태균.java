package 분할정복.풀어야할문제.쿼드트리_1992_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int N;
    public static int[][] VIDEO;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        VIDEO = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                VIDEO[i][j] = str.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(SB.toString());
    }

    public static void divide(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            SB.append(VIDEO[row][col]);
            return;
        }

        SB.append("(");

        divide(row, col, size / 2);
        divide(row, col + (size / 2), size / 2);
        divide(row + (size / 2), col, size / 2);
        divide(row + (size / 2), col + (size / 2), size / 2);

        SB.append(")");
    }

    public static boolean checkColor(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (VIDEO[i][j] != VIDEO[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

}