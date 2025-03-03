package class4.풀어야할문제.최단경로_1753_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 방향그래프가 주어지고
 * 시작점에서 다른 모든 정점으로의 최단경로를 구하라
 * 모든 간선의 가중치는 10 이하의 자연수이다.
 */
public class 황병수 {

    static int V,E,S;
    static List<Node>[] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());

        result = new int[V+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) map[i] = new ArrayList<>();


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[u].add(new Node(v,w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (i == S) {
                System.out.println(0);
            } else if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S,0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int nowEnd = poll.end;
            int nowValue = poll.value;

            for (Node node : map[nowEnd]) {
                int nextEnd = node.end;
                int nextValue = node.value;

                if (result[nextEnd] > nowValue + nextValue) {
                    result[nextEnd] = nowValue + nextValue;
                    pq.add(new Node(nextEnd, result[nextEnd]));
                }
            }

        }
    }


    static class Node implements Comparable<Node>{
        int end, value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
