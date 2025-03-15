package class4.풀어야할문제.정수삼각형_1932_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[][] TRIANGLE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        TRIANGLE = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                TRIANGLE[i][j] = num;
            }
        }

        for (int row = N - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int max = Math.max(TRIANGLE[row + 1][col], TRIANGLE[row + 1][col + 1]);
                TRIANGLE[row][col] += max;
            }
        }

        System.out.println(TRIANGLE[0][0]);
    }

}