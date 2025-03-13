package class4.풀어야할문제.N과M2_15650_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모2 {

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

    private static void backtracking(int num) {

        if( arr.size() == M ) {
            for( int result : arr ) {
                System.out.print(result + " ");
            }
            System.out.println();
            return;
        }

        for( int i = num +1; i <= N; i++ ) {
            arr.add(i);
            backtracking(i);
            arr.remove( arr.size() - 1 );
        }

    }
}
