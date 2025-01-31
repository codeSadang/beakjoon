package 다이나믹프로그래밍.시험볼문제.Bunnies_26529_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수열
 * 일수별로 메모이제이션으로 기록해놓고 꺼내쓴다.
 */
public class 황병수 {

    static int[] fibonacciList = new int[46];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TestCase = Integer.parseInt(br.readLine());
        fibonacciList[0] = 1;
        fibonacciList[1] = 1;

        for (int i = 0; i < TestCase; i++) {
            int Day = Integer.parseInt(br.readLine());

            if (fibonacciList[Day] != 0) {
                sb.append(fibonacciList[Day]).append('\n');
                continue;
            }

            for (int j = 2; j <= Day; j++) {
                fibonacciList[j] = fibonacciList[j-1] + fibonacciList[j-2];
            }

            sb.append(fibonacciList[Day]).append('\n');
        }

        System.out.println(sb);
    }
}
