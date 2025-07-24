package 깊이우선탐색.풀어야할문제.연결요소의개수_11724_실버2;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 홍창모 {
    static List<List<Integer>> GRAPH;

    static boolean[] VISITED;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        GRAPH = new ArrayList<>();
        VISITED = new boolean[N+1];

        for( int i = 0; i <= N; i++ ) {
            GRAPH.add(new ArrayList<>());
        }

        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            GRAPH.get(u).add(v);
            GRAPH.get(v).add(u);
        }

        int connectCnt = 0;
        for( int i = 1; i <= N; i++ ) {
            if( !VISITED[i] ) {
                dfs(i);
                connectCnt++;
            }
        }

        System.out.println(connectCnt);
    }

    private static void dfs(int index) {
        VISITED[index] = true;

        for( int connect : GRAPH.get(index) ) {
            if( !VISITED[connect] ) {
                dfs(connect);
            }
        }
    }
}
