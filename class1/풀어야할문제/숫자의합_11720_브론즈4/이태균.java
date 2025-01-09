package class1.풀어야할문제.숫자의합_11720_브론즈4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");

        int sum = 0;

        for (String s : str) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }

}