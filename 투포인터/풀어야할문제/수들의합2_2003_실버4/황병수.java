package 투포인터.풀어야할문제.수들의합2_2003_실버4;

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
    static int result;
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


        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < N) {
            // 현재 부분합이 목표 M과 같을 때
            if (sum == M) {
                result++;
                sum -= AList[left];
                left++;
            }
            // 현재 부분합이 M보다 작을 때, right 이동 (범위 체크 필수)
            else if (sum < M) {
                if (right < N) {
                    sum += AList[right];
                    right++;
                } else {
                    break;
                }
            }
            // 현재 부분합이 M보다 클 때, left 이동
            else {
                sum -= AList[left];
                left++;
            }
        }

        System.out.println(result);
    }
}
