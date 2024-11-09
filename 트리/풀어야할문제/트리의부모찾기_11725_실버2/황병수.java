package 트리.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 황병수 {
    static int N;
    static int[] result;
    static List<List<Integer>> AList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N+1];
        AList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            AList.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            AList.get(u).add(v);
            AList.get(v).add(u);
        }


        // 깊이 우선 탐색
//        dfs();
        
        // 넓이 우선 탐색
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            for (int child : AList.get(curr)) {
                if (!visited[child]) {
                    visited[child] = true;
                    result[child] = curr;
                    stack.add(child);
                }
            }
        }
    }

    // BFS 함수
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();  // 큐 사용
        queue.add(1);
        boolean[] visited = new boolean[N+1];  // 방문 여부 체크 배열
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 현재 노드와 연결된 자식 노드들 탐색
            for (int child : AList.get(curr)) {
                if (!visited[child]) {
                    visited[child] = true;   // 자식 노드 방문 처리
                    result[child] = curr;    // 부모 노드 설정
                    queue.add(child);        // 큐에 자식 노드 추가
                }
            }
        }
    }
}
