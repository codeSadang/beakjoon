package 투포인터.완료된문제.수들의합2_2003_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 수로 된 수열
 *
 * i번째부터 j번쨰의 수까지의 합이 M이 되는 경우의 프로그램을 작성하시오
 */
public class 황병수 {

    static int N,M;
    static int[] AList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        AList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, left = 0, right = 0, count = 0;

        while (right < N) {

            sum += AList[right++];

            while (sum > M && left < right) {
                sum -= AList[left++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
