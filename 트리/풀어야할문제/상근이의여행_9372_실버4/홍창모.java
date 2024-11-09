package 트리.풀어야할문제.상근이의여행_9372_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int T, N, M;

    static boolean[] visited;

    static ArrayList<ArrayList<Integer>> airplaneList = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for( int i = 0; i < T; i++ ) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            airplaneList = new ArrayList<ArrayList<Integer>>();
            visited = new boolean[N + 1];

            for( int j = 0; j <= N; j++ ) {
                airplaneList.add(new ArrayList<>());
            }

            M = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                airplaneList.get(u).add(v);
                airplaneList.get(v).add(u);
            }

            int result = dfs(1, 0);
            System.out.println(result);

        }
    }

    public static int dfs(int now, int count) {
        visited[now] = true;

        for( int next : airplaneList.get(now) ) {
            if ( !visited[next] ) count = dfs(next, count + 1);
        }

        return count;
    }
}
