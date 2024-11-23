package 이분탐색.풀어야할문제.개똥벌레_3020_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, H;

    static int[] top, bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 종유석
        top = new int[N/2];
        // 석순
        bottom = new int[N/2];

        for( int i = 0; i < N/2; i++ ) {
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }

        // 정렬처리
        Arrays.sort(top);
        Arrays.sort(bottom);

        int min = N;
        int cnt = 0;

        for( int i = 1; i <= H; i++ ) {
            // 높이만큼 반복문처리
            int dis = binarySearch( i, 0, N/2, bottom ) + binarySearch( H-i+1, 0, N/2, top);

            if( min == dis ) {
                cnt++;
                continue;
            }

            if( min > dis ) {
                min = dis;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);

    }

    public static int binarySearch( int h, int lt, int rt, int[] arr ) {
        int result = 0;

        while( lt < rt ) {

            int mid = lt + (rt - lt) / 2;

            if( arr[mid] >= h ) {
                rt = mid;
            } else {
                lt = mid + 1;
            }

        }


        result = arr.length - rt;

        return result;
    }
}
