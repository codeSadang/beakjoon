package 데이크스트라.풀어야할문제.특정거리의도시찾기_18352_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N; // 도시의 개수
    public static int M; // 도로의 개수
    public static int K; // 거리 정보
    public static int X; // 출발 도시의 번호

    public static int[] DISTANT_LIST;
    public static List<List<Node>> NODE_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        DISTANT_LIST = new int[N + 1];
        Arrays.fill(DISTANT_LIST, Integer.MAX_VALUE);
        DISTANT_LIST[X] = 0;
        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            NODE_LIST.get(u).add(new Node(v, 1));
        }

        dijkstra(X);

        boolean visit = false;
        for (int i = 1; i <= N; i++) {
            if (DISTANT_LIST[i] == K) {
                System.out.println(i);
                visit = true;
            }
        }

        if (!visit) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(s, 0));

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