package class1.풀어야할문제.검증수_2475_브론즈5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 5; i ++) {
            sum += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        System.out.println(sum % 10);
    }

}