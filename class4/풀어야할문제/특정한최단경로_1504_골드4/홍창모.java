package class4.풀어야할문제.특정한최단경로_1504_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정점의 개수는 N이다.
 * 간선의 개수는 E이다.
 * 1번 정점에서 N번 정점으로 가는 최단 거리를 구해야 한다.
 *
 * A번 정점과 B번 정점은 반드시 지나야한다.
 * 1. 1번 정점에서 A번 정점까지의 최단 거리 + A번 정점에서 B번 정점까지의 최단 거리 + B번 정점에서 N번 정점까지의 최단 거리
 * 2. 1번 정점에서 B번 정점까지의 최단 거리 + B번 정점에서 A번 정점까지의 최단 거리 + A번 정점에서 N번 정점까지의 최단 거리
 *
 * */
public class 홍창모 {

    static class Node {
        int pos, length;

        Node(int pos, int length) {
            this.pos = pos;
            this.length = length;
        }
    }

    static int N, E;

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for( int i = 1; i <= N; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0; i < E; i++ ) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            // 양방향이므로 반대로도 추가
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, A);
        if (result1 != Integer.MAX_VALUE) {
            int temp = dijkstra(A, B);
            if (temp != Integer.MAX_VALUE) {
                result1 += temp;
                temp = dijkstra(B, N);
                if (temp != Integer.MAX_VALUE) {
                    result1 += temp;
                } else {
                    result1 = Integer.MAX_VALUE;
                }
            } else {
                result1 = Integer.MAX_VALUE;
            }
        }

        int result2 = dijkstra(1, B);
        if (result2 != Integer.MAX_VALUE) {
            int temp = dijkstra(B, A);
            if (temp != Integer.MAX_VALUE) {
                result2 += temp;
                temp = dijkstra(A, N);
                if (temp != Integer.MAX_VALUE) {
                    result2 += temp;
                } else {
                    result2 = Integer.MAX_VALUE;
                }
            } else {
                result2 = Integer.MAX_VALUE;
            }
        }

        int answer = Math.min(result1, result2);

        if (answer >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.length));
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while( !pq.isEmpty() ) {
            Node current = pq.poll();

            int pos = current.pos;
            int length = current.length;

            if( length > distance[pos] ) {
                continue;
            }

            for( Node next : graph[pos] ) {
                if( distance[next.pos] > distance[pos] + next.length ) {
                    distance[next.pos] = distance[pos] + next.length;
                    pq.add(new Node(next.pos, distance[next.pos]));
                }
            }
        }

        return distance[end];
    }
}
