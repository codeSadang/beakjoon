package 투포인터.풀어야할문제.용액_2467_골드5;

/**
 * 산성 용액, 알칼리성 용액을 보유
 * 산성용액의 특성값은 1 ~ 10^9
 * 알칼리 용액 특성값은 -1 ~ -10^9
 * 같은 양의 두용액을 혼합한 용액의 특성값은 사용된 각 용액의 특성갓의 합으로 정의
 * 0에 가까운 수를 만들어야함
 *
 * 두개의 서로 다른 두 용액을 혼합하여 특성값이 0에 가까운 용액을 만들어내기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오름차순으로 나열되어 있으니 처음 인덱스와 마지막인덱스로 시작해서 절대값이 작은 것을 찾기
 */
public class 황병수 {

    static int N;
    static int[] AList;
    static int minResult = Integer.MAX_VALUE;
    static int[] result = new int[2];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        AList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = AList[left] + AList[right];
            if (minResult >= Math.abs(sum)) {
                minResult = Math.min(minResult, Math.abs(sum));
                result[0] = AList[left];
                result[1] = AList[right];
            }

            if (sum >= 0) right--;
            if (sum < 0) left++;
        }

        System.out.println(result[0]+ " " +result[1]);
    }
}
