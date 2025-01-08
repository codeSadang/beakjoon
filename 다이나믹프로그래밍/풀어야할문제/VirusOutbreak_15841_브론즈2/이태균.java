package 다이나믹프로그래밍.풀어야할문제.VirusOutbreak_15841_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class 이태균 {

    public static BigInteger[] DP;
    public static List<Integer> TIME_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;

        while (true) {
            int time = Integer.parseInt(br.readLine());
            if (time == -1) {
                break;
            }

            TIME_LIST.add(time);

            if (time > max) {
                max = time;
            }
        }

        DP = new BigInteger[max + 1];

        DP[0] = BigInteger.ZERO;
        DP[1] = BigInteger.ONE;

        for (int i = 2; i <= max; i++) {
            DP[i] = DP[i - 2].add(DP[i - 1]);
        }

        for (Integer t : TIME_LIST) {
            sb.append("Hour ").append(t).append(": ").append(DP[t]).append(" cow(s) affected").append("\n");
        }

        System.out.print(sb);
    }
}
