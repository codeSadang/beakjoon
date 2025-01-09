package class1.풀어야할문제.사칙연산_10869_브론즈5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(a + b).append("\n").append(a - b).append("\n").append(a * b).append("\n").append(a / b).append("\n").append(a % b);

        System.out.println(sb);
    }

}