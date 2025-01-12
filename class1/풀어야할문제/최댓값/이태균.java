package class1.풀어야할문제.최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max_idx = -1;
        int max = -1;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) {
                max = num;
                max_idx = i + 1;
            }
        }

        sb.append(max).append("\n").append(max_idx);
        System.out.println(sb);
    }

}