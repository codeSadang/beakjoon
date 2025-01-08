package 다이나믹프로그래밍.풀어야할문제.피보나치수4_10826_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 이태균 {

    public static int N;
    public static BigInteger[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        } else if (N == 1) {
            System.out.println(1);
            return;
        }

        DP = new BigInteger[N + 1];
        DP[0] = BigInteger.ZERO;
        DP[1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1].add(DP[i - 2]);
        }

        System.out.println(DP[N]);
    }

}