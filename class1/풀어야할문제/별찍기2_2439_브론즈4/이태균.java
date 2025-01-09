package class1.풀어야할문제.별찍기2_2439_브론즈4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < i; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}