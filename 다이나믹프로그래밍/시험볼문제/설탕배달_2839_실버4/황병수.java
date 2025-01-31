package 다이나믹프로그래밍.시험볼문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3KG, 5KG 각각 봉지가 있는데 최대한 5KG 을 많이 담아야한다.
 * 최대한 적은 봉지수의 개수를 구하여라
 * 정확하게 N킬로그램을 만들 수 없다면 -1을 출력하여라
 * 범위는 3 < N < 5000
 */
public class 황병수 {

    static int[] factory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Total = Integer.parseInt(br.readLine());

        factory = new int[Total+1];
        Arrays.fill(factory, 5000);

        if (Total >= 3) factory[3] = 1;
        if (Total >= 5) factory[5] = 1;

        for (int i = 6; i <= Total; i++) {
            if (factory[i-3] < 5000) factory[i] = Math.min(factory[i],  factory[i-3] + 1);
            if (factory[i-5] < 5000) factory[i] = Math.min(factory[i],  factory[i-5] + 1);
        }

        if (factory[Total] == 5000) {
            System.out.println(-1);
        } else {
            System.out.println(factory[Total]);
        }
    }
}
