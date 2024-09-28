package 깊이우선탐색.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static List<Integer>[] tree;  // 트리 구조
    static int[] parents;          // 각 노드의 부모
    static boolean[] visited;      // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        // 초기화
        tree = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        // 트리 초기화
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // DFS 시작 (루트 노드 1에서 시작)
        dfs(1, 0);

        // 각 노드의 부모 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    // DFS 메소드
    static void dfs(int current, int parent) {
        visited[current] = true; // 현재 노드 방문 처리
        parents[current] = parent; // 부모 정보 저장

        for (Integer neighbor : tree[current]) {
            if (!visited[neighbor]) { // 방문하지 않은 노드라면
                dfs(neighbor, current); // 재귀 호출
            }
        }
    }
}
