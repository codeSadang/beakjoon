package 투포인터.완료된문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, m;
    static int[] A, B;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n];
        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++ ) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        System.out.print(sb.toString());
    }

    public static void twoPoint(  ) {

        int p1 = 0, p2 = 0;

        sb = new StringBuilder();

        while( p1 < n && p2 < m ) {
            if( A[p1] < B[p2] ) {
                sb.append(A[p1++]).append(" ");
            } else {
                sb.append(B[p2++]).append(" ");
            }
        }

        // p1이나 p2중 남은 배열 요소를 뒤에 붙여준다.
        while( p1 < n ) {
            sb.append(A[p1++]).append(" ");
        }

        while( p2 < m ) {
            sb.append(B[p2++]).append(" ");
        }
    }
}
