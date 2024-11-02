package 투포인터.풀어야할문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Long[] A = new Long[n];
        Long[] B = new Long[m];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            A[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++ ) {
            B[i] = Long.parseLong(st.nextToken());
        }

        System.out.print(twoPoint(A, B, n, m));
    }

    public static String twoPoint( Long[] A, Long[] B, int n, int m ) {

        int p1 = 0, p2 = 0;

        StringBuilder sb = new StringBuilder();

        while( p1 < n && p2 < m ) {
            if( A[p1] < B[p2] ) {
                sb.append( A[p1++] + " " );
            } else {
                sb.append( B[p2++] + " " );
            }
        }

        // p1이나 p2중 남은 배열 요소를 뒤에 붙여준다.
        while( p1 < n ) {
            sb.append( A[p1++] + " " );
        }

        while( p2 < m ) {
            sb.append( B[p2++] + " " );
        }

        return sb.toString();
    }
}
