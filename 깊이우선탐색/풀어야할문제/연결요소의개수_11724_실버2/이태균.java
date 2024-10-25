package 깊이우선탐색.풀어야할문제.연결요소의개수_11724_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static List<List<Integer>> GRAPH_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            GRAPH_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            GRAPH_LIST.get(u).add(v);
            GRAPH_LIST.get(v).add(u);
        }

        int linkedCount = 0;

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i]) {
                dfs(i);
                linkedCount++;
            }
        }

        System.out.println(linkedCount);
    }

    private static void dfs(int now) {
        VISITED[now] = true;

        for (int next : GRAPH_LIST.get(now)) {
            if (!VISITED[next]) {
                dfs(next);
            }
        }
    }

}