package 다이나믹프로그래밍.시험볼문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int T;

    public static int FLOOR;
    public static int NUMBER;
    public static int[][] APART;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            FLOOR = Integer.parseInt(br.readLine());
            NUMBER = Integer.parseInt(br.readLine());

            APART = new int[FLOOR + 1][NUMBER + 1];
            for (int j = 1; j <= NUMBER; j++) {
                APART[0][j] = j;
            }

            for (int j = 1; j <= FLOOR; j++) {
                for (int k = 1; k <= NUMBER; k++) {
                    APART[j][k] = APART[j - 1][k] + APART[j][k - 1];
                }
            }

            sb.append(APART[FLOOR][NUMBER]).append("\n");
        }

        System.out.println(sb);
    }

}