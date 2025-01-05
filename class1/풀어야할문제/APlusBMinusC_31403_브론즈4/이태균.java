package class1.풀어야할문제.APlusBMinusC_31403_브론즈4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = new String[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = br.readLine();
        }

        int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]) - Integer.parseInt(numbers[2]);
        String str = numbers[0] + numbers[1];
        int sum2 = Integer.parseInt(str) - Integer.parseInt(numbers[2]);

        System.out.println(sum);
        System.out.println(sum2);
    }

}