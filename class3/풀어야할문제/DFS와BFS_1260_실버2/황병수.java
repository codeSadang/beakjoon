package class3.풀어야할문제.DFS와BFS_1260_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * dfs와 bfs로 탐색한 결과를 출력하라
 * 단, 방문할 수 있는 정점이 여러개인 경우, 정점번호가 작은것 먼저 방문
 * 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1~N 까지이다.
 * 첫째 줄에 정점의 개수 N, 간선의 개수 M, 탐색 시작할 정점의 번호 V
 * M개의 줄에는 간선이 연결되는 두 정점의 번호가 주어진다.
 * 입력으로 주어지는 간선은 양방향이다.
 */
public class 황병수 {

    static int N,M,V;
    static boolean[] visited;
    static List<Node>[] map;
    static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].add(new Node(end));
            map[end].add(new Node(start));
        }

        // 정점 번호가 작은 순서대로 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        Arrays.fill(visited, false);
        bfs();

        System.out.println(sb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(" ");

        for (Node next : map[now]) {
            if (!visited[next.end]) dfs(next.end);
        }
    }

    private static void bfs() {
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.addLast(new Node(V));
        visited[V] = true;

        while (!que.isEmpty()) {
            Node now = que.pollFirst();
            int NowEnd = now.end;
            sb.append(NowEnd).append(" ");

            for (Node next : map[NowEnd]) {
                if (!visited[next.end]) {
                    que.addLast(new Node(next.end));
                    visited[next.end] = true;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;

        public Node(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.end, o.end);
        }
    }
}
