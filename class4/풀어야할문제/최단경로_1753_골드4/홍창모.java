package class4.풀어야할문제.최단경로_1753_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {

    static class Node {
        int pos, length;

        Node(int pos, int length) {
            this.pos = pos;
            this.length = length;
        }
    }

    static List<Node>[] graph;

    static int[] distance;

    static int V, E, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        V = Integer.parseInt(st.nextToken());
        // 간선의 개수
        E = Integer.parseInt(st.nextToken());
        // 시작 정점
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];

        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for( int i = 1; i <= V; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0; i < E; i++ ) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra();

        for( int i = 1; i <= V; i++ ) {
            if( distance[i] >= Integer.MAX_VALUE ) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.length));

        distance[K] = 0;
        pq.add(new Node(K, 0));

        while( !pq.isEmpty() ) {
            Node curr = pq.poll();

            int pos = curr.pos;
            int length = curr.length;

            if( length > distance[pos] ) continue;

            for( Node next : graph[pos] ) {
                if( distance[next.pos] > distance[pos] + next.length ) {
                    distance[next.pos] = distance[pos] + next.length;
                    pq.add(new Node(next.pos, distance[next.pos]));
                }
            }
        }
    }
}
