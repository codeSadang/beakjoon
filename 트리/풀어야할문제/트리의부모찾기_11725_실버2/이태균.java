package 트리.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static List<List<Integer>> TREE = new ArrayList<>();
    public static boolean[] VISITED;

    public static int[] PARENT;
    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            TREE.add(new ArrayList<>());
        }

        VISITED = new boolean[N + 1];
        PARENT = new int[N + 1];

        StringTokenizer st;
        for (int j = 0; j < N - 1; j++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            TREE.get(u).add(v);
            TREE.get(v).add(u);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            SB.append(PARENT[i]).append("\n");
        }
        System.out.print(SB);
    }

    private static void dfs(int now) {
        VISITED[now] = true;

        for (int next : TREE.get(now)) {
            if (!VISITED[next]) {
                PARENT[next] = now;
                dfs(next);
            }
        }
    }
}