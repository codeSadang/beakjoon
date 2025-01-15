package 다이나믹프로그래밍.시험볼문제.일로만들기_1463_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int X;
    public static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        DP = new int[X + 1];
        DP[1] = 0;

        for (int i = 2; i <= X; i++) {
            DP[i] = DP[i - 1] + 1;

            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }

            if (i % 3 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }
        }

        System.out.println(DP[X]);
    }
}