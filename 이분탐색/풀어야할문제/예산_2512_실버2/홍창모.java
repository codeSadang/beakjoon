package 이분탐색.풀어야할문제.예산_2512_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static int[] BUDGET;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BUDGET = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            BUDGET[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        // 정렬처리
        Arrays.sort(BUDGET);

        System.out.print( binarySearch() );


    }

    public static int binarySearch() {

        int result = 0;

        int lt = 1, rt = BUDGET[N-1];

        while ( lt <= rt ) {
            int mid = lt + ( rt - lt ) / 2;

            long sum = 0;

            for( int i = 0; i < N; i++ ) {
                if( BUDGET[i] >= mid ) {
                    sum += mid;
                } else {
                    sum += BUDGET[i];
                }
            }

            if( sum <= M ) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }
        return result;
    }
}
