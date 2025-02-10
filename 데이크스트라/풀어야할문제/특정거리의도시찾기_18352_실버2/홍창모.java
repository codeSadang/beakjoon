package 데이크스트라.풀어야할문제.특정거리의도시찾기_18352_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {

    static int N, M, K, X;
    static List<List<Integer>> graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 개수
        N = Integer.parseInt(st.nextToken());
        // 도로의 개수
        M = Integer.parseInt(st.nextToken());
        // 거리 정보
        K = Integer.parseInt(st.nextToken());
        // 출발 도시
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        dijkstra(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[currentNode]) {
                continue;
            }

            for (int nextNode : graph.get(currentNode)) {
                int newDistance = currentDistance + 1;
                if (newDistance < distance[nextNode]) {
                    distance[nextNode] = newDistance;
                    pq.add(new int[]{nextNode, newDistance});
                }
            }
        }
    }
}