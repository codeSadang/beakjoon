package 깊이우선탐색.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;

    public static List<List<Integer>> NODE_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static int[] PARENT_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[N + 1];
        PARENT_LIST = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            NODE_LIST.get(u).add(v);
            NODE_LIST.get(v).add(u);
        }

        dfs(1);


    }

    private static void dfs(int now) {
        VISITED[now] = true;

        for (Integer next : NODE_LIST.get(now)) {

            if (!VISITED[next]) {
                PARENT_LIST[next] = now;
                System.out.println("!!! : " + now);
                dfs(next);
            }
        }


    }

}