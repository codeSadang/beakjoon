package 깊이우선탐색.풀어야할문제.DFS와BFS_1260_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 이태균 {

    public static int N;
    public static int M;
    public static int V;

    public static List<List<Integer>> NODE_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static List<Integer> DFS_LIST = new ArrayList<>();
    public static List<Integer> BFS_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 개수 N, 간선의 개수 M, 탐색 시작 정점 V를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프의 각 정점을 위한 리스트 초기화 (1번 정점부터 N번 정점까지 사용)
        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        // 간선 정보를 입력받아 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결
            NODE_LIST.get(u).add(v);
            NODE_LIST.get(v).add(u);
        }

        // 방문 여부 배열 초기화
        VISITED = new boolean[N + 1];

        // 작은 번호의 정점부터 방문할 수 있도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(NODE_LIST.get(i));
        }

        dfs(V);

        // 방문 여부 배열 재초기화
        VISITED = new boolean[N + 1];

        bfs(V);

        System.out.println(DFS_LIST.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        System.out.println(BFS_LIST.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void dfs(int idx) {
        VISITED[idx] = true;
        DFS_LIST.add(idx);

        for (int now : NODE_LIST.get(idx)) {
            if (!VISITED[now]) {
                dfs(now);
            }
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        VISITED[idx] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            BFS_LIST.add(now);

            for (int node : NODE_LIST.get(now)) {
                if (!VISITED[node]) {
                    VISITED[node] = true;
                    q.add(node);
                }
            }
        }
    }
}
