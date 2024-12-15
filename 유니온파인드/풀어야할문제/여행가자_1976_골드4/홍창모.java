package 유니온파인드.풀어야할문제.여행가자_1976_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static int[] unf;

    static ArrayList<Integer> temp = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        unf = new int[N+1];

        for( int i = 1; i <= N; i++ ) unf[i] = i;

        for( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 1; j <= N; j++ ) {
                int v = Integer.parseInt(st.nextToken());

                if( v == 1 ) {
                    union(i, j);
                }
            }

        }

        st = new StringTokenizer(br.readLine());

        // 토큰이 존재할때까지 반복문을 돌림
        while( st.hasMoreTokens() ) {
            temp.add(Integer.parseInt(st.nextToken()));
        }

        int fa = find(temp.get(0));
        boolean flag = true;
        for( int i = 1; i < temp.size(); i++ ) {
            int fb = find(temp.get(i));

            if( fa != fb ) {
                flag = false;
                break;
            }
        }

        if( flag ) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if( fa != fb ) unf[fa] = fb;
    }

    public static int find(int v) {
        if( v == unf[v] ) return v;
        else return unf[v] = find(unf[v]);
    }
}
