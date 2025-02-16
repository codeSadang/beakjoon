package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {

    static class Node {
        int pos, depth;
        Node(int pos, int depth) {
            this.pos = pos;
            this.depth = depth;
        }
    }
    static int N,K;

    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[100001];
        visited = new boolean[100001];

        for(int i = 0; i <= 100000; i++) {
            graph[i] = new ArrayList<>();
        }

        //System.out.println(dijkstra(N, K));
        System.out.print(bfs(N, K));
    }

    private static int dijkstra(int N, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.depth));
        pq.add(new Node(N, 0));

        while( !pq.isEmpty() ) {

            Node current = pq.poll();
            int pos = current.pos;
            int depth = current.depth;

            if( pos == K ) {
                return depth;
            }

            if (visited[pos]) {
                continue;
            }
            visited[pos] = true;

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                pq.add(new Node(pos * 2, depth));
                graph[pos * 2].add(new Node(pos, depth));
            }

            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                pq.add(new Node(pos + 1, depth + 1));
                graph[pos + 1].add(new Node(pos, depth + 1));
            }

            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.add(new Node(pos - 1, depth + 1));
                graph[pos - 1].add(new Node(pos, depth + 1));
            }

        }

        return -1;
    }

    public static int bfs(int start, int end) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(start, 0));

        while (!deque.isEmpty()) {
            Node now = deque.poll();
            int pos = now.pos;
            int depth = now.depth;

            if (pos == end) {
                return depth;
            }

            if (visited[pos]) {
                continue;
            }
            visited[pos] = true;

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                deque.offerFirst(new Node(pos * 2, depth));
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                deque.offerLast(new Node(pos - 1, depth + 1));
            }
            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                deque.offerLast(new Node(pos + 1, depth + 1));
            }
        }

        return -1;
    }
}
