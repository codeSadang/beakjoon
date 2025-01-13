package 다이나믹프로그래밍.풀어야할문제.피보나치수2_2748_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] fibonachi = new long[N+1];

        fibonachi[0] = 0;
        fibonachi[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibonachi[i] = fibonachi[i-1] + fibonachi[i-2];
        }

        System.out.println(fibonachi[N]);
    }
}
