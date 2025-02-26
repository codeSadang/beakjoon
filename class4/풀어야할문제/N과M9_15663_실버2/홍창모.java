package class4.풀어야할문제.N과M9_15663_실버2;

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
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        backtracking(0);
    }

    private static void backtracking(int num) {
        if( num == M ) {
            for( int result : arr ) {
                System.out.print( result + " " );
            }
            System.out.println();
            return;
        }

        int before = -1;
        for( int i = 0; i < N; i++ ) {
            if( !visited[i] && before != numbers[i] ) {
                visited[i] = true;
                arr.add(numbers[i]);
                before = numbers[i];
                backtracking(num+1);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
