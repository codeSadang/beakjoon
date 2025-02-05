package 데이크스트라.특정거리의도시찾기_18352_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static int N,M,K,X;
    static int[] result;
    static List<List<Integer>> input = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[X] = 0;

        for (int i = 0; i <= N; i++) {
            input.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            input.get(start).add(end);
        }

        dijkstra(X);

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (result[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int current = poll[0];
            int distance = poll[1];

            if (result[current] < distance) continue;

            for (int next : input.get(current)) {
                if (result[next] > result[current] + 1) {
                    result[next] = result[current] + 1;
                    pq.add(new int[]{next, result[next]});
                }
            }
        }
    }
}
