package 데이크스트라.지름길_1446_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class 윤지연 {
    static final int INF = Integer.MAX_VALUE;
    static int N,D;
    static int[] distance;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distance = new int [D + 1];
        Arrays.fill(distance, INF);

        // 그래프 초기화
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
            if (i < D) {
                graph.get(i).add(new Node(i + 1, 1));
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (v <= D && u < v && w < v - u) {
                graph.get(u).add(new Node(v, w));
            }
        }

        dijkstra(0);
        System.out.println(distance[D]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 현재 거리가 이미 알고 있는 거리보다 크면 무시
            if (distance[current.vertex] < current.cost) continue;

            // 현재 정점과 연결된 다른 정점들 확인
            for (Node next : graph.get(current.vertex)) {
                if (distance[next.vertex] > distance[current.vertex] + next.cost) {
                    distance[next.vertex] = distance[current.vertex] + next.cost;
                    pq.offer(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
    }

}
