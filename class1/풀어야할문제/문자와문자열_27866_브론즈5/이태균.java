package class1.풀어야할문제.문자와문자열_27866_브론즈5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(i - 1));
    }

}