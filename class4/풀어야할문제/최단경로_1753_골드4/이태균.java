package class4.풀어야할문제.최단경로_1753_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int V;
    public static int E;
    public static int K;
    public static List<List<Node>> NODE_LIST;
    public static int[] DISTANT_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        DISTANT_LIST = new int[V + 1];
        Arrays.fill(DISTANT_LIST, Integer.MAX_VALUE);

        NODE_LIST = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            NODE_LIST.get(u).add(new Node(v, w));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (DISTANT_LIST[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(DISTANT_LIST[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(K, 0));
        DISTANT_LIST[K] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > DISTANT_LIST[current.end]) {
                continue;
            }

            for (Node next : NODE_LIST.get(current.end)) {
                int newCost = DISTANT_LIST[current.end] + next.cost;

                if (newCost < DISTANT_LIST[next.end]) {
                    DISTANT_LIST[next.end] = newCost;
                    pq.offer(new Node(next.end, newCost));
                }
            }
        }
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