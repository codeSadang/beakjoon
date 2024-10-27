package 백트래킹.풀어야할문제.N과M1_15649_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);
    }

    public static void dfs(int L) {

        if( L == m ) {
            for( int x : arr ) {
                System.out.print( x + " ");
            }
            System.out.println();
            return;
        }

        for ( int i = 0; i < n; i++ ) {
            if(!visited[i]) {
                visited[i] = true;
                arr[L] = i +1;
                dfs(L + 1);
                visited[i] = false;
            }
        }

    }
}
