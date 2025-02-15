package 데이크스트라.풀어야할문제.지름길_1446_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수2 {

    static class Node implements Comparable<Node> {
        int pos, cost;
        Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, D;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) graph[i] = new ArrayList<>();

        // 기본 도로 (1씩 증가하는 도로)
        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        // 지름길 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (next > D) continue; // 도착지를 초과하는 지름길 무시
            if (next - current <= distance) continue; // 지름길이 더 길면 무의미

            graph[current].add(new Node(next, distance));
        }

        // 다익스트라 실행
        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.pos]) continue; // 기존 거리보다 크면 무시

            for (Node next : graph[now.pos]) {
                if (dist[next.pos] > dist[now.pos] + next.cost) {
                    dist[next.pos] = dist[now.pos] + next.cost;
                    pq.add(new Node(next.pos, dist[next.pos]));
                }
            }
        }

        return dist[D];
    }
}