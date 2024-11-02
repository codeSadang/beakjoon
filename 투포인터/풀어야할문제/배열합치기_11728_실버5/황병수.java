package 투포인터.풀어야할문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정렬되어있는 두 배열 A,B가 주어진다.
 * 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 배열 A의 크기 N, B의 크기 m 이 주어진다.
 * 둘째 줄에는 A의 내용
 * 셋째 줄에는 B의 내용
 *
 * 첫째줄에 두 배열을 합친 후 정렬한 결과를 출력한다.
 */
public class 황병수 {
    static int[] A;
    static int[] B;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int indexA = 0;
        int indexB = 0;

        StringBuilder sb = new StringBuilder();
        while (indexA < N && indexB < M) {
            if (A[indexA] >= B[indexB]) {
                sb.append(B[indexB++]).append(" ");
            } else {
                sb.append(A[indexA++]).append(" ");
            }
        }

        while (indexA < N) {
            sb.append(A[indexA++]).append(" ");
        }

        while (indexB < M) {
            sb.append(B[indexB++]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
