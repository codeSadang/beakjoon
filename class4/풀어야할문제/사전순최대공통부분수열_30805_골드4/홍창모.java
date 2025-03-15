package class4.풀어야할문제.사전순최대공통부분수열_30805_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static List<Integer> result, temp;
    static StringTokenizer st;

    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < M; i++ ) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = num;
        }

        result = LCS();

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        for( int num : result ) {
            sb.append(num).append(" ");
        }

        System.out.print(sb);
    }

    private static List<Integer> LCS() {
        List<Integer> lcs = new ArrayList<>();

        int n = A.length, m = B.length;

        int i = 0, j =0;
        while( i < n && j < m ) {
            int maxValue = -1, maxIndexA = -1, maxIndexB = -1;

            for( int x = i; x < n; x++ ) {
                for( int y = j; y < m; y++ ) {
                    if( A[x] == B[y] && A[x] > maxValue ) {
                        maxValue = A[x];
                        maxIndexA = x;
                        maxIndexB = y;
                    }
                }
            }

            if (maxValue == -1) break; // 더 이상 공통 원소가 없으면 종료

            // 결과에 추가하고 다음 위치로 이동
            lcs.add(maxValue);
            i = maxIndexA + 1;
            j = maxIndexB + 1;
        }

        return lcs;
    }
}
