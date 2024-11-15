package 이분탐색.풀어야할문제.나무자르기_2805_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 나무 M 미터가 필요하다.
 *
 * 나무 한줄이 주어지면, 정해진 H만큼의 길이에서 잘라내고 남은 길이를 모두 더할거임!!
 */
public class 황병수 {
    static int N,M;
    static long result = 0;
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

        Arrays.sort(AList);

        long left = 0;
        long right = AList[N-1];
        long mid = 0;
        while (left <= right) {

            mid = (left + right) / 2;

            long TotalTreeLength = cutTree(mid);

            if (TotalTreeLength >= M) {
                result = mid;
                left = mid + 1;

            } else {
                right = mid -1;
            }

        }

        System.out.println(result);
    }

    private static long cutTree(long mid) {
        long totalLength = 0;
        for (int i = 0; i < N; i++) {
            if (AList[i] >= mid) {
                totalLength += (AList[i] - mid);
            }

        }

        return totalLength;
    }
}
