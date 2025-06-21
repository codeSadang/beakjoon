package 분할정복.풀어야할문제.색종이만들기_2630_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균_색종이만들기 {

    public static int N;
    public static int[][] CONFETTI;
    public static int[] RESULT = new int[2];

    /**
     * Reads the size and color grid of a square paper from standard input, counts the number of uniform color square pieces using a divide-and-conquer approach, and prints the counts for each color.
     *
     * The input consists of an integer N followed by N lines of N integers (0 or 1), representing the color grid.
     * The output is two lines: the number of all-zero and all-one uniform color squares, respectively.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an I/O error occurs during input reading
     */
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

    /**
     * Recursively divides a square section of the grid to count uniform color sub-squares.
     *
     * If the specified sub-square is uniform in color, increments the count for that color.
     * Otherwise, subdivides the section into four equal quadrants and processes each recursively.
     *
     * @param row  the starting row index of the sub-square
     * @param col  the starting column index of the sub-square
     * @param size the length of the side of the sub-square
     */
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

    /**
     * Determines whether all cells in the specified sub-square have the same color.
     *
     * @param row  the starting row index of the sub-square
     * @param col  the starting column index of the sub-square
     * @param size the size of the sub-square
     * @return true if all cells in the sub-square are the same color; false otherwise
     */
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