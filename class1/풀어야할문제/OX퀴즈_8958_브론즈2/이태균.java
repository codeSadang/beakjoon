package class1.풀어야할문제.OX퀴즈_8958_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int count = 0;
            int sum = 0;

            for (char c : chars) {
                if (c == 'O') {
                    count++;

                    sum += count;
                } else {
                    count = 0;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}