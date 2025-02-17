package class4.풀어야할문제.내려가기_2096_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] answer = new int[2][3];
        Arrays.fill(answer[0], 0); // 최소값
        Arrays.fill(answer[1], 0); // 최대값
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            // 현재 값을 임시 저장
            int min0 = answer[0][0], min1 = answer[0][1], min2 = answer[0][2];
            int max0 = answer[1][0], max1 = answer[1][1], max2 = answer[1][2];

            // 최소값 계산
            answer[0][0] = Math.min(min0, min1) + one;
            answer[0][1] = Math.min(Math.min(min0, min1), min2) + two;
            answer[0][2] = Math.min(min1, min2) + three;

            // 최대값 계산
            answer[1][0] = Math.max(max0, max1) + one;
            answer[1][1] = Math.max(Math.max(max0, max1), max2) + two;
            answer[1][2] = Math.max(max1, max2) + three;
        }

        int min = Math.min(Math.min(answer[0][0], answer[0][1]), answer[0][2]);
        int max = Math.max(Math.max(answer[1][0], answer[1][1]), answer[1][2]);
        System.out.println(max + " " + min);
    }
}
