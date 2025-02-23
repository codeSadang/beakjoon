package class4.풀어야할문제.N과M4_15652_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        backtracking(0);
    }

    private static void backtracking(int i) {

        if( arr.size() == M ) {
            for( int result : arr ) {
                System.out.print( result + " " );
            }
            System.out.println();
            return;
        }

        for( int j = i; j <= N; j++ ) {
            if( j > 0 ) {
                arr.add(j);
                backtracking(j);
                arr.remove( arr.size() - 1 );
            }
        }

    }
}
