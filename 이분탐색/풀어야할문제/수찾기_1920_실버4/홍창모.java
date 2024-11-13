package 이분탐색.풀어야할문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, m;

    static int[] A, B;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        B = new int[m];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < m; i++ ) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열 정렬
        Arrays.sort(A);

        for( int i = 0; i < m; i++ ) {
            if( binarySearch(B[i]) ) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static boolean binarySearch(int target) {

        int lt = 0, rt = n-1;

        while( lt <= rt ) {
            int mid = lt + (rt - lt) / 2;

            if( A[mid] == target ) {
                return true;
            } else if( A[mid] < target ) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return false;
    }
}
