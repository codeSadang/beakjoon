package 유니온파인드.풀어야할문제.집합의표현_1717_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static StringBuilder sb = new StringBuilder();

    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        unf = new int[N+1];

        // index를 세팅해준다.
        for( int i = 0; i <= N; i++ ) unf[i] =i;
        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( type == 0 ) {
                // a의 집합과 b의 집합을 합치는 합집합
                union(a, b);

            } else {
                // 두 원소가 같은 집합에 포함되어 있는지 확인
                String result = isUnion(a, b);

                sb.append(result).append("\n");
            }

        }

        System.out.println(sb.toString());
    }

    private static int find(int v) {
        if( v == unf[v] ) return v;
        else return unf[v] = find(unf[v]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if( fa != fb ) unf[fa] = fb;
    }

    private static String isUnion(int a, int b) {
        String result = "NO";

        int fa = find(a);
        int fb = find(b);

        if( fa == fb ) result = "YES";

        return result;
    }


}
