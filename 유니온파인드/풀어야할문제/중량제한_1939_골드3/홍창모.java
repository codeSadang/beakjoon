package 유니온파인드.풀어야할문제.중량제한_1939_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 미완 */
public class 홍창모 {

    static int N, M;

    static int[] parent;
    static int[][] bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 섬의 개수
        M = Integer.parseInt(st.nextToken());   // 다리의 개수

        parent = new int[N+1];  // 부모 배열 초기화

        for( int i = 1; i <= N; i++ ) {
            parent[i] = i;
        }

        // 다리의 정보를 저장할 배열
        bridge = new int[M][3];

        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bridge[i][0] = a;       // 섬 a
            bridge[i][1] = b;       // 섬 b
            bridge[i][2] = c;       // 중량 제한
        }

        st = new StringTokenizer(br.readLine());

    }

    public static int find(int v) {
        if( v == parent[v] ) return v;
        else return parent[v] = find(parent[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if( fa != fb ) parent[fa] = fb;
    }
}
