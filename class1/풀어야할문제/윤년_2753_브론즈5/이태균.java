package class1.풀어야할문제.윤년_2753_브론즈5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        if ((year % 4 == 0) && year % 100 != 0 || year % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}