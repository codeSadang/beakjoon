package 다이나믹프로그래밍.풀어야할문제.피보나치수4_10826_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        if (N == 0) {
            System.out.println(0);
        } else if (N == 1) {
            System.out.println(1);
        }  else {
            BigInteger[] fibonacci = new BigInteger[N+1];

            fibonacci[0] = BigInteger.ZERO;
            fibonacci[1] = BigInteger.ONE;

            for (int i = 2; i <= N; i++) {
                fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
            }

            System.out.println(fibonacci[N]);
        }
    }
}
