package 그리디.풀어야할문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 이태균 {

    public static Integer[] DELIVERY = {3, 5};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int count = 0;

        for (Integer integer : DELIVERY) {
            count += N / integer;
            N %= integer;
        }

        if (N == 0) {
            System.out.println(count);
            return;
        }

        System.out.println(-1);
    }

}