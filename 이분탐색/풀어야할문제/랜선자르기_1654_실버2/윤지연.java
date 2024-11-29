package 이분탐색.풀어야할문제.랜선자르기_1654_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*특이사항
* int로 계산 시 오버플로우 발생하면서 무한루프 발생함*/
public class 윤지연 {
    static int K, N;
    static long[] cables;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cables = new long[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            max = Math.max(max, cables[i]);
        }

        binarySearch();
    }

    public static void binarySearch() {
        long s = 1;
        long e = max;
        long min = 1;

        while (s <= e) {
            long mid = s + (e - s) / 2;

            if (canCut(mid)) {
                min = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(min);
    }

    private static boolean canCut(long length) {
        int count = 0;

        for (long cable : cables) {
            count += cable / length;
        }
        return count >= N;
    }
}
