package 다이나믹프로그래밍.시험볼문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치와 마찬가지로
 * 내 아래층의 1호부터 내 호수까지 사는 사람의 합이 나의 수가 된다.
 *
 * 호수는 1호부터 있으면 0층의 i호에는 i명이 산다.
 *
 */
public class 황병수 {

    static int[][] fibonacciList = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 14; i++) {
            fibonacciList[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                if (j == 1) {
                    fibonacciList[i][j] = fibonacciList[i - 1][j];
                } else {
                    fibonacciList[i][j] = fibonacciList[i - 1][j] + fibonacciList[i][j-1];
                }
            }
        }

        for (int i = 0; i < TestCase; i++) {

            int floor = Integer.parseInt(br.readLine());
            int count = Integer.parseInt(br.readLine());

            sb.append(fibonacciList[floor][count]).append('\n');

        }

        System.out.println(sb);
    }
}
