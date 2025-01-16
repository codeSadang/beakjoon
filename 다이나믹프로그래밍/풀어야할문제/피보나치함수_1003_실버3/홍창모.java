package 다이나믹프로그래밍.풀어야할문제.피보나치함수_1003_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 홍창모 {

    static int T;

    static int[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        fibo = new int[41];

        fibo[0] = 0;
        fibo[1] = 1;

        // 40까지의 자연수의 피보나치 수열 입력
        for( int i = 2; i <= 40; i++ ) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        for( int i = 0; i < T; i++ ) {
            int num = Integer.parseInt(br.readLine());

            if( num == 0 ) {
                sb.append(1).append(" ").append(0).append("\n");
            } else if( num == 1 ) {
                sb.append(0).append(" ").append(1).append("\n");
            } else {
                sb.append(fibo[num-1]).append(" ").append(fibo[num]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
