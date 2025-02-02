package 다이나믹프로그래밍.시험볼문제.VirusOutbreak_15841_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 윤지연 {
    public static BigInteger[] dp = new BigInteger[491];
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i <= 490; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        while (true){
            int x = Integer.parseInt(br.readLine());
            if (x == -1) break;

            answer.append("Hour ")
                    .append(x)
                    .append(": ")
                    .append(dp[x])
                    .append(" cow(s) affected")
                    .append("\n");
        }
        System.out.println(answer.toString().trim());
    }
}
