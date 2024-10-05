package 깊이우선탐색.풀어야할문제.알고리즘수업dfs1_24479_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다.
 * 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
 * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 * <p>
 * 깊이 우선 탐색 의사 코드는 다음과 같다.
 * 인접 정점은 오름차순으로 방문한다.
 * <p>
 * dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
 * visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
 * for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
 * if (visited[x] = NO) then dfs(V, E, x);
 * }
 */
public class 이태균 {

    public static int N;
    public static int M;
    public static int R;

    // 그래프 구조(인접 리스트)
    public static List<List<Integer>> GRAPH;
    public static boolean[] VISITED;

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
        }
        VISITED = new boolean[N + 1];

        // 그래프 내 간선 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향 그래프 == 양방향 그래프
            GRAPH.get(u).add(v);
            GRAPH.get(v).add(u);
        }

        int size = GRAPH.size();
        for (int i = 0; i < size; i++) {
            Collections.sort(GRAPH.get(i));
        }

        dfs(R);
        SB.append("0");
        System.out.print(SB);
    }

    private static void dfs(int R) {
        VISITED[R] = true;
        SB.append(R).append("\n");

        for (int neighbor : GRAPH.get(R)) {
            if (!VISITED[neighbor]) {
                dfs(neighbor);
            }
        }
    }

}