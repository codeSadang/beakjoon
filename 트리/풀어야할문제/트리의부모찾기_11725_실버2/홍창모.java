package 트리.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;

    static boolean[] visited;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static HashMap<Integer, Integer> result = new HashMap<Integer, Integer>() ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        StringTokenizer st;
        for( int i = 0; i <= N; i++ ) {
            graph.add(new ArrayList<Integer>());
        }

        for( int i = 0; i < N-1; i++ ) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1,0);

        StringBuilder sb = new StringBuilder();
        for( int i = 2; i <= N; i++ ) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.print(sb.toString()  );
    }

    public static void dfs(int node, int parent) {
        visited[node] = true;

        if( parent > 0 ) result.put(node, parent);

        for( int child : graph.get(node) ) {
            if( !visited[child] ) {
                dfs(child, node);
            }
        }
    }
}
