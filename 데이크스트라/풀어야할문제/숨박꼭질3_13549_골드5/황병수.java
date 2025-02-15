package 데이크스트라.풀어야할문제.숨박꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 황병수 {

    static int N, K;
    static boolean find = false;
    static boolean[] visited = new boolean[100001]; // 방문 체크
    static boolean[] visited2 = new boolean[100001]; // 방문 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

//        System.out.println(bfs());
        System.out.println(bfs2());

    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.depth - b.depth); // 시간 기준 우선순위 정렬
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.pos;
            int depth = node.depth;

            if (now == K) return depth; // 목표 지점 도달

            if (visited[now]) continue; // 이미 방문한 곳이라면 패스
            visited[now] = true;

            // 순간이동 (0초)
            if (now * 2 <= 100000) pq.add(new Node(now * 2, depth));
            // 걷기 (1초)
            if (now - 1 >= 0) pq.add(new Node(now - 1, depth + 1));
            if (now + 1 <= 100000) pq.add(new Node(now + 1, depth + 1));

        }
        return -1; // 도달 불가능한 경우 (이론상 없음)
    }

    private static int bfs2() {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(N, 0));

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst(); // 가장 앞에 있는 노드 꺼내기
            int now = node.pos;
            int depth = node.depth;

            if (now == K) return depth; // 목표 지점 도달

            if (visited2[now]) continue; // 이미 방문한 곳이라면 패스
            visited2[now] = true;

            // 순간이동 (0초) → 덱 앞에 추가 (우선 탐색)
            if (now * 2 <= 100000 ) deque.addFirst(new Node(now * 2, depth));

            // 걷기 (1초) → 덱 뒤에 추가
            if (now - 1 >= 0) deque.addLast(new Node(now - 1, depth + 1));
            if (now + 1 <= 100000) deque.addLast(new Node(now + 1, depth + 1));

        }
        return -1; // 도달 불가능한 경우 (이론상 없음)
    }

    static class Node {
        int pos, depth;
        Node(int pos, int depth) {
            this.pos = pos;
            this.depth = depth;
        }
    }
}
