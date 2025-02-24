package class4.풀어야할문제.특정한최단경로_1504_골드4;


import 데이크스트라.풀어야할문제.지름길_1446_실버1.황병수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 방향성이 없는 그래프
 * 세준이는 1번 정점에서 N번 정점으로 최단거리 이동
 * 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶다.
 *
 * 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다.
 *
 * 한번 이동했던 정점은 물론 간선도 다시 사용할 수 있다.
 * 반드시 최단경로로 이동해야 한다.
 *
 * 1번 정점에서 N번 정점으로 이동할 때, 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오
 *
 * 첫쨰줄에 점점 개수 N과 간선의 개수 E개의 줄에 걸쳐서 3개의 정수가 주어지는데
 *
 * a번 정점에서 b 정점까지 양방향 길이 존재하며 거리는 c이다
 *
 * 마지막에는 두개의 서로 다른 정점 번호 v1, v2가 주어진다.
 */
public class 황병수 {

    static int[][] result = new int[2][3];
    static List<Node>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[left].add(new Node( right, value));
            map[right].add(new Node(left, value));
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int AToB = dijkstra(a, b);

        int oneToA = dijkstra(1, a);
        int AToN = dijkstra(a, N);

        int oneToB = dijkstra(1, b);
        int BToN = dijkstra(b, N);


        int caseAB = (oneToA == -1 || AToB == -1 || BToN == -1) ? Integer.MAX_VALUE : oneToA + AToB + BToN;
        int caseBA = (oneToB == -1 || AToB == -1 || AToN == -1) ? Integer.MAX_VALUE : oneToB + AToB + AToN;

        int result = Math.min(caseAB, caseBA);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[map.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.value > dist[now.right]) continue; // 이미 처리된 값이면 스킵

            for (Node node : map[now.right]) {
                int newDist = now.value + node.value;
                if (newDist < dist[node.right]) {
                    dist[node.right] = newDist;
                    pq.add(new Node(node.right, newDist));
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }


    static class Node implements Comparable<Node> {
        int  right, value;
        public Node( int right, int value) {
            this.right = right;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
