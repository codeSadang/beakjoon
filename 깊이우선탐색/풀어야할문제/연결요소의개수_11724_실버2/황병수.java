package 깊이우선탐색.풀어야할문제.연결요소의개수_11724_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static List<Integer>[] graph;  // 그래프 구조
    static boolean[] visited;       // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 방향 없는 그래프
        }

        int componentCount = 0; // 연결 요소 개수

        // 모든 노드에 대해 DFS 실행
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 노드라면
                dfs(i); // DFS 호출
                componentCount++; // 새로운 연결 요소 발견
            }
        }

        // 연결 요소의 개수 출력
        System.out.println(componentCount);
    }

    // DFS 메소드
    static void dfs(int current) {
        visited[current] = true; // 현재 노드 방문 처리

        for (Integer neighbor : graph[current]) {
            if (!visited[neighbor]) { // 방문하지 않은 노드라면
                dfs(neighbor); // 재귀 호출
            }
        }
    }
}
