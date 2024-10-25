package 백트래킹.풀어야할문제.ABCDE_13023_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static int N, C;
    static List<List<Integer>> relations;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        relations = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            relations.get(u).add(v);
            relations.get(v).add(u);
        }

        // 처음 DFS 호출을 모든 노드에 대해 수행하도록 설정
        for (int i = 0; i < N; i++) {
            if (result) break;
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        System.out.println(result ? 1 : 0);
    }

    static void dfs(int idx, int depth) {

        if(depth == 5) {
            result = true;
            return;
        }

        for (int now : relations.get(idx)) {
            if (!visited[now]) {
                visited[now] = true;
                dfs(now, depth + 1);
                visited[now] = false;
            }
        }
    }
}
