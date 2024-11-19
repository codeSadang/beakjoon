package 이분탐색.풀어야할문제.랜선자르기_1654_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int K, N;

    static long[] lanCable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lanCable = new long[K];

        for( int i = 0; i < K; i++ ) {
            lanCable[i] = Integer.parseInt(br.readLine());
        }

        // 랜선 길이 정렬
        Arrays.sort(lanCable);

        long answer = binarySearch();

        System.out.print(answer);

    }

    public static long binarySearch() {
        long result = 0;

        long lt = 1, rt = lanCable[K-1];

        while( lt <= rt ) {
            long mid = lt + (rt - lt) / 2;

            long cnt = 0;
            for( int i = 0; i < K; i++ ) {
                cnt += lanCable[i] / mid;
            }

            if( cnt >= N ) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }

        return result;
    }
}
