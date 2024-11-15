package 이분탐색.풀어야할문제.숫자카드_10815_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 숫자 카드는 정수 하나가 적혀져 있는 카드
 * 상근이는 숫자카드 N개를 가지고 있다.
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자카드를 산근이가 가지고 있는지 아닌지 구하는 프로그램
 */
public class 황병수 {

    static int N, M;
    static Integer[] AList, BList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        AList = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        BList = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            BList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);
//        Arrays.sort(AList, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int targetNum = BList[i];
            int left = 0;
            int right = N-1;
            int mid = 0;
            boolean check = false;
            while (left <= right) {
                mid = (left + right) / 2;
                if (targetNum == AList[mid]) {
                    check = true;
                    break;
                } else if (targetNum > AList[mid]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }

            if (check) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb);


    }
}
