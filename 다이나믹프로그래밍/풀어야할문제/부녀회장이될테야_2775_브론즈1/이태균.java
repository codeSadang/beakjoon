package 다이나믹프로그래밍.풀어야할문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이태균 {

    public static int T;
    public static int[][] APART;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int floor = Integer.parseInt(br.readLine());
            int number = Integer.parseInt(br.readLine());

            APART = new int[floor + 1][number + 1];
            for (int j = 1; j <= number; j++) {
                APART[0][j] = j;
            }

            for (int j = 1; j <= floor; j++) {
                for (int k = 1; k <= number; k++) {
                    APART[j][k] = APART[j - 1][k] + APART[j][k - 1];
                }
            }

            sb.append(APART[floor][number]).append("\n");
        }

        System.out.println(sb);
    }

}