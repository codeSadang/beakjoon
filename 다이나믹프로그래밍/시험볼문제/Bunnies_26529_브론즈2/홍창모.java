package 다이나믹프로그래밍.시험볼문제.Bunnies_26529_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fibo = new int[46];

        fibo[0] = 1;
        fibo[1] = 1;

        for( int i = 2; i <= 45; i++ ) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        for( int i = 0; i < n; i++ ) {
            int x = Integer.parseInt(br.readLine());

            sb.append( fibo[x] ).append("\n");
        }

        System.out.print(sb);
    }
}
