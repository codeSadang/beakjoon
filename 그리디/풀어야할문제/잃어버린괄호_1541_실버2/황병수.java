package 그리디.풀어야할문제.잃어버린괄호_1541_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitA = br.readLine().split("-");
        
        for (int i = 0; i < splitA.length; i++) {
            String[] split = splitA[i].split("\\+"); // "+"를 기준으로 나눔

            int sum = 0; // 합계 변수 초기화
            for (String s : split) {
                sum += Integer.parseInt(s); // 각 값을 정수로 변환하여 더함
            }

            splitA[i] = String.valueOf(sum);
        }

        int result = Integer.parseInt(splitA[0]);
        for (int i = 1; i < splitA.length; i++) {
            result -= Integer.parseInt(splitA[i]);
        }

        System.out.println(result);
    }
}
