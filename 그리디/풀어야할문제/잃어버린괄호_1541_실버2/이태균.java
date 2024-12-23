package 그리디.풀어야할문제.잃어버린괄호_1541_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] formula = br.readLine().split("-");
        int[] temp = new int[formula.length];

        for (int i = 0; i < formula.length; i++) {
            int sum = 0;
            String[] numbers = formula[i].split("\\+");
            for (String n : numbers) {
                int num = Integer.parseInt(n);
                sum += num;
            }

            temp[i] = sum;
        }

        int result = temp[0];
        for (int i = 1; i < temp.length; i++) {
            result -= temp[i];
        }

        System.out.println(result);
    }

}