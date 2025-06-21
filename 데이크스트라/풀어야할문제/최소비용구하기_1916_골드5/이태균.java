package 데이크스트라.풀어야할문제.최소비용구하기_1916_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] DISTANT_LIST;
    public static List<List<Node>> NODE_LIST = new ArrayList<>();
    public static int START;
    public static int END;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        DISTANT_LIST = new int[N + 1];
        Arrays.fill(DISTANT_LIST, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            NODE_LIST.add(new ArrayList<>());
            NODE_LIST.get(u).add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());

        DISTANT_LIST[START] = 0;
        dijkstra();

        System.out.println(DISTANT_LIST[END]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(START, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > DISTANT_LIST[now.dest]) {
                continue;
            }

            for (Node next : NODE_LIST.get(now.dest)) {
                int nextCost = DISTANT_LIST[now.dest] + next.cost;
                if (DISTANT_LIST[next.dest] > nextCost) {
                    DISTANT_LIST[next.dest] = nextCost;
                    pq.add(new Node(next.dest, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}