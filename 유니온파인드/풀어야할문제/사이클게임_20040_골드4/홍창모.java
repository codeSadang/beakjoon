package 유니온파인드.풀어야할문제.사이클게임_20040_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M, ANSWER = 0;

    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        unf = new int[N];

        for(int i = 0; i < N; i++) unf[i] = i;

        for( int i = 1; i <= M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( find(a) == find(b) ) {
                ANSWER = i;
                break;
            } else {
                union(a, b);
            }

        }

        if( ANSWER != 0 ) {
            System.out.println(ANSWER);
        } else {
            System.out.println(0);
        }
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if( fa != fb ) unf[fa] = fb;
    }

    private static int find(int v) {
        if( v == unf[v] ) return v;
        else return unf[v] = find(unf[v]);
    }
}
