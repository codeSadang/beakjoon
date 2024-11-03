package 투포인터.완료된문제.귀여운라이언_15565_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 꿀귀 라ㅣ언 인형과 꿀구인 어피치 인형이 N개 일렬로 놓여있다.
 * 라이언 인형은 1
 * 어피치 인형은 2
 * 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기를 구하여라.
 */
public class 황병수 {

    static int N, K;
    static int[] AList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        AList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < N && left < N) {
            if (AList[left] == 2) {
                left++;

            } else if (count >= K) {
                result = Math.min(result, (right - left));
                count--;
                left++;

            } else {
                if (AList[right] == 1) {
                    count++;
                }
                right++;
            }
        }

        if (count >= K) {
            result = Math.min(result, (right - left));
        }

        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }
}
