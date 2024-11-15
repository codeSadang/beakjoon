package 이분탐색.풀어야할문제.랜선자르기_1654_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 캠프에 쓸 N개의 랜선을 만들어야함
 * K개의 랜선을 가지고 있으나, 길이가 제각각임
 *
 * 랜선을 모두 N개의 같은 길이의 랜선으로 만들어야 하기 때문에
 * K개의 랜선을 잘라서 만들어야함
 *
 * 300cm 짜리 랜선에서 140cm 짜리 두개를 잘라내면 20cm는 버려야함. (쓸 수 없음)
 * 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정.
 *
 * 만들 수 있는 최대 랜선의 길이를 구하시오.
 */
public class 황병수 {
    static int K, N;
    static long maxLength = Long.MIN_VALUE;
    static long[] AList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        AList = new long[K];
        for (int i = 0; i < K; i++) {
            AList[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(AList);

        long left = 1;               // 최소 길이를 1로 설정
        long right = AList[K - 1];    // 가장 긴 랜선의 길이
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long count = calcMethod(mid);
            if (count >= N) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxLength);
    }

    static long calcMethod(long length) {   // long 타입으로 변경
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += AList[i] / length;
        }
        return count;
    }
}
