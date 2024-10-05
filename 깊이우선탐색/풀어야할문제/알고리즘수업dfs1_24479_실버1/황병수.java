package 깊이우선탐색.풀어야할문제.알고리즘수업dfs1_24479_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    public static int N;
    public static int M;
    public static int R;
    public static HashMap<Integer, Integer> VISIT_ORDER = new HashMap<>();
    public static List<List<Integer>> GRAPH;
    public static boolean[] VISITED;

    public static int count = 1;
    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        GRAPH = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            GRAPH.add(new ArrayList<>());
            VISIT_ORDER.put(i,0);
        }
        VISITED = new boolean[N + 1];

        // 그래프 내 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향 그래프 == 양방향 그래프
            GRAPH.get(u).add(v);
            GRAPH.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(GRAPH.get(i));
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            SB.append(VISIT_ORDER.get(i));
            if (i != N) {
                SB.append("\n");  // 마지막 요소가 아닌 경우에만 줄바꿈 추가
            }
        }

        System.out.println(SB);
    }

    private static void dfs(int R) {
        VISITED[R] = true;
        VISIT_ORDER.put(R, count++);

        for (int neighbor : GRAPH.get(R)) {
            if (!VISITED[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}