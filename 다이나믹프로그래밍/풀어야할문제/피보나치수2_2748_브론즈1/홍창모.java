package 다이나믹프로그래밍.풀어야할문제.피보나치수2_2748_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[] fibo = new long[N+1];

        fibo[0] = 0;
        fibo[1] = 1;

        for( int i = 2; i <= N; i++ ) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        System.out.println(fibo[N]);
    }
}
