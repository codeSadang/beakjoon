package 깊이우선탐색.풀어야할문제.DFS와BFS_1260_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    * 입력처리
    * N: 정점 개수
    * M: 간석 개수
    * V: 시작 정점
    * M개의 간선
    * */
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder resultDfs = new StringBuilder();
    static StringBuilder resultBfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 정점의 수만큼 리스트 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            addEdge(v, w);
        }

        // 인접리스트 정렬
        for (ArrayList arr : graph) {
            Collections.sort(arr);
        }

        dfs(V);
        bfs(V);

        System.out.println(resultDfs.toString());
        System.out.println(resultBfs.toString());
    }

    // bfs
    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        // 시작 노드 방문 처리
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드 꺼내기
            int v = queue.poll();
            resultBfs.append(v).append(" ");

            // 인접한 노드 중 방문하지 않은 노드 탐색
            for (int neighbor : graph.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // dfs
    static void dfs(int start) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        stack.push(start);

        // 스택이 빌 때까지 반복
        while (!stack.isEmpty()) {
            int v = stack.pop();

            // 방문하지 않은 경우에만 처리
            if (!visited[v]) {
                visited[v] = true;
                resultDfs.append(v).append(" ");

                // 인접 노드들을 역순으로 스택에 push
                // 작은 번호 방문을 우선하기 위해 역순으로 push
                for (int i = graph.get(v).size() - 1; i >= 0; i--) {
                    int neighbor = graph.get(v).get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    // 간선 추가 메서드
    static void addEdge(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    // 인접 리스트 저장 확인
    static void printGraph() {
        for (int i = 1; i < graph.size(); i++) {
            System.out.print(i + "번 정점의 인접 정점들: ");
            // 각 정점의 인접 리스트 출력
            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
