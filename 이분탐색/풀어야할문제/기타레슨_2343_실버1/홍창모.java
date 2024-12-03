package 이분탐색.풀어야할문제.기타레슨_2343_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;        // 레슨 수, 블루레이 수

    static int[] arr;       // 레슨 시간 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = binarySearch();

        System.out.print(answer);
    }

    public static int binarySearch() {
        int answer = 0;

        // 최소 블루레이 크기는 레슨 시간 중 가장 큰 값
        int lt = Arrays.stream(arr).max().getAsInt();
        // 최대 블루레이 크기는 레슨 시간의 총합
        int rt = Arrays.stream(arr).sum();

        while( lt <= rt ) {
            int mid = lt + (rt - lt) / 2;

            if( blueRayCount(mid) <= M ) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static int blueRayCount(int mid) {
        int cnt = 1, sum = 0;

        for( int x : arr ) {
            if( sum + x > mid ) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }
}
