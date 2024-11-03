package 투포인터.완료된문제.먹을것인가먹힐것인가_7795_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for( int i=0; i<T;i++ ) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for( int j=0; j<N; j++ ) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for( int j=0; j<M; j++ ) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(twoPoint(A, B));
        }
    }

    public static int twoPoint(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int ai = 0;

        while( ai < A.length ) {
            int bi = 0;
            while(bi < B.length) {
                if( A[ai] <= B[bi] ) {
                    break;
                } else {
                    answer++;
                    bi++;
                }
            }
            ai++;
        }

        return answer;
    }
}
