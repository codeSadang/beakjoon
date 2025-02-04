package 데이크스트라.특정거리의도시찾기_18352_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N,M,K,X;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
            graph.get(s).add(e);
        }

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

    static void dijkstra(int s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        distance[s] = 0;
        pq.add(s);

        while (!pq.isEmpty()) {
            int current = pq.poll();

            if (distance[current] < distance[s]) continue;

            for (Integer next : graph.get(current)) {
                if (distance[next] > distance[current] + 1) {
                    distance[next] = distance[current] + 1;
                    pq.offer(next);
                }
            }
        }
    }
}
