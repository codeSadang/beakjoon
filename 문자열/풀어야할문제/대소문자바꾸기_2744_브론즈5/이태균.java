package 문자열.풀어야할문제.대소문자바꾸기_2744_브론즈5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");

        char[] chars = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            chars[i] = str[i].charAt(0);
        }

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                char lowerChar = Character.toLowerCase(c);
                sb.append(lowerChar);
            } else {
                char upperChar = Character.toUpperCase(c);
                sb.append(upperChar);
            }
        }

        System.out.println(sb);
    }

}