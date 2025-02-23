package class4.풀어야할문제.N과M2_15650_실버3;

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
            for( int num : arr ) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for( int j = i+1; j <= N; j++ ) {
            arr.add(j);
            backtracking(j);
            arr.remove(arr.size()-1);
        }

    }
}
