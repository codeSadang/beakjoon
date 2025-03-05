package class4.풀어야할문제.특정한최단경로_1504_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N;
    public static int E;
    public static List<List<Node>> NODE_LIST = new ArrayList<>();
    public static int U;
    public static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            NODE_LIST.get(a).add(new Node(b, c));
            NODE_LIST.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 다익스트라 수행
        int[] start = dijkstra(1); // 1에서 모든 노드로의 최단 거리
        int[] v1 = dijkstra(U); // U에서 모든 노드로의 최단 거리
        int[] v2 = dijkstra(V); // V에서 모든 노드로의 최단 거리

        long path1 = Integer.MAX_VALUE;
        long path2 = Integer.MAX_VALUE;

        if (start[U] != Integer.MAX_VALUE && v1[V] != Integer.MAX_VALUE && v2[N] != Integer.MAX_VALUE) {
            path1 = (long) start[U] + v1[V] + v2[N]; // 1 -> v1 -> v2 -> N
        }

        if (start[V] != Integer.MAX_VALUE && v2[U] != Integer.MAX_VALUE && v1[N] != Integer.MAX_VALUE) {
            path2 = (long) start[V] + v2[U] + v1[N]; // 1 -> v2 -> v1 -> N
        }

        // 두 경로 중 더 작은 경로를 출력
        long min = Math.min(path1, path2);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int[] dijkstra(int start) {
        int[] distanceList = new int[N + 1];
        Arrays.fill(distanceList, Integer.MAX_VALUE);
        distanceList[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > distanceList[now.end]) {
                continue;
            }

            for (Node next : NODE_LIST.get(now.end)) {
                // 새로운 거리 계산
                int nextDist = distanceList[now.end] + next.cost;
                // 새로운 거리가 기존 거리보다 짧으면 업데이트
                if (nextDist < distanceList[next.end]) {
                    distanceList[next.end] = nextDist;
                    pq.offer(new Node(next.end, nextDist));
                }
            }
        }

        return distanceList;
    }

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
