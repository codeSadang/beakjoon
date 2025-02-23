package class4.풀어야할문제.N과M5_15654_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static List<Integer> arr;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        backtracking(0);
    }

    private static void backtracking(int i) {

        if( arr.size() == M ) {
            for( int result : arr ) {
                System.out.print(result + " ");
            }
            System.out.println();
            return;
        }

        for( int j = 0; j < N; j++ ) {
            if( !arr.contains(numbers[j]) ) {
                arr.add(numbers[j]);
                backtracking(j);
                arr.remove(arr.size()-1);
            }
        }

    }
}
