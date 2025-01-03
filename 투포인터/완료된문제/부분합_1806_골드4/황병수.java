package 투포인터.완료된문제.부분합_1806_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10000이하의 자연수로 이루어진 길이 N짜리 수열
 *
 * 이 수열에서 연속된 수들의 부분합 중에 그 합이 S이상이 되는것중 가장 짧은것의 길이를 구하라
 */
public class 황병수 {

    static int N,S;
    static int[] AList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        AList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {

            if (sum >= S) {
                result = Math.min(result, right - left);
                sum -= AList[left];
                left++;
            }
            else if (right == N || result == 1) break;

            else {
                sum += AList[right];
                right++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE? 0 : result);
    }
}
