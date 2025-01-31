package 다이나믹프로그래밍.시험볼문제.VirusOutbreak_15841_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 황병수 {
    static BigInteger[] fibonacciList = new BigInteger[491];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fibonacciList[0] = BigInteger.ONE;
        fibonacciList[1] = BigInteger.ONE;

        for (int i = 2; i <= 490; i++) {
            fibonacciList[i] = fibonacciList[i - 1].add(fibonacciList[i - 2]);
        }

        while (true) {
            int Day = Integer.parseInt(br.readLine());
            if (Day == -1) break;

            sb.append("Hour ").append(Day).append(": ").append(fibonacciList[Day-1]).append(" cow(s) affected").append('\n');
        }

        System.out.print(sb);
    }
}
