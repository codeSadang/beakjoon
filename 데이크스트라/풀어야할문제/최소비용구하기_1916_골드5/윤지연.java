package 데이크스트라.풀어야할문제.최소비용구하기_1916_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 윤지연 {
    static int[] distance;
    static List<List<Bus>> map = new ArrayList<>();
    /*
    * N: 도시 개수(1부터 시작)
    * M: 버스 개수
    *
    * 1 2 2: 출발 도착 비용
    * */

    static class Bus implements Comparable<Bus> {
        int dest, cost;

        Bus(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        // 버스 노선 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(s).add(new Bus(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s);

        System.out.println(distance[e]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus current = pq.poll();

            if (distance[current.dest] < current.cost) continue;

            for (Bus next : map.get(current.dest)) {
                int newCost = distance[current.dest] + next.cost;
                if (distance[next.dest] > newCost) {
                    distance[next.dest] = newCost;
                    pq.offer(new Bus(next.dest, newCost));
                }
            }
        }
    }
}
