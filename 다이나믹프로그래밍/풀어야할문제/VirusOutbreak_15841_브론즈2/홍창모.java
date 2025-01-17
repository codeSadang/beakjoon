package 다이나믹프로그래밍.풀어야할문제.VirusOutbreak_15841_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        BigInteger[] cows = new BigInteger[491];

        cows[0] = BigInteger.ZERO;
        cows[1] = BigInteger.ONE;

        for(int i = 2; i < 491; i++) {
            cows[i] = cows[i-1].add(cows[i-2]);
        }

        while(true) {
            int hour = Integer.parseInt(br.readLine());

            if( hour == -1 ) {
                System.out.println(sb);
                break;
            } else {
                sb.append("Hour ").append(hour).append(": ").append(cows[hour]).append(" cow(s) affected").append("\n");
            }
        }

    }
}
