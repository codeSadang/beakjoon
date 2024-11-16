package 이분탐색.풀어야할문제.예산_2512_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 국가가 여러 지방의 예산요청을 심사하여 에산 분배
 * 정해진 총액 이하에서 가능한 최대의 총 예산을 배정
 * 1. 모든 요청이 배정될 수 있는 경우에 그대로 배정
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 게산하여, 그 이상인 예산 요청에는 모두 상한액을 배정
 * 상한액 이하의 요청에대해서는 요청금액 그대로 배정
 *
 *
 */
public class 황병수 {
    static int N,M;
    static int[] AList;
    static long result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(AList);

        long left = 0;
        long right = AList[N-1];
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long count = cut(mid);

            if (count >= 0) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long cut(long maxMoney) {

        int restMoney = M;
        for (int i = 0; i < N; i++) {
            if (AList[i] <= maxMoney) {
                restMoney -= AList[i];
            } else {
                restMoney -= maxMoney;
            }
        }

        return restMoney;
    }
}
