package 투포인터.완료된문제.수열_2559_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어짐
 * 연속적인 며칠동안의 온도의 합이 가장 큰값을 알아보자
 */
public class 황병수 {

    static int N, K;
    static int[] AList;
    static int result = Integer.MIN_VALUE;
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
        int right = K - 1;

        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += AList[i];
        }
        result = sum;
        while (right < N -1 ) {
            sum -= AList[left++];
            sum += AList[++right];
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
