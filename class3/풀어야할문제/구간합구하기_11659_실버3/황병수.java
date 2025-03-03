package class3.풀어야할문제.구간합구하기_11659_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 N개가 주어졌을 때 i번째 수부터 j번째 수까지 합을 구하는 프로그램
 */
public class 황병수 {
    static int N,M;

    static int[] numList;
    static int[] sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int cnt = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());

        numList = new int[cnt+1];
        sumList = new int[cnt+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= cnt; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
            sumList[i] = numList[i] + sumList[i-1];
        }

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());

            sb.append(sumList[end] - sumList[start]).append('\n');
        }

        System.out.println(sb);
    }
}
