package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int K;
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        VISITED = new boolean[100001];

        int result = bfs(N, K);
        System.out.println(result);
    }

    public static int bfs(int start, int end) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(start, 0));

        while (!deque.isEmpty()) {
            Node now = deque.poll();
            int nowPos = now.pos;
            int nowTime = now.time;

            if (nowPos == end) {
                return nowTime;
            }

            if (VISITED[nowPos]) {
                continue;
            }
            VISITED[nowPos] = true;

            if (nowPos * 2 <= 100000 && !VISITED[nowPos * 2]) {
                deque.offerFirst(new Node(nowPos * 2, nowTime));
            }
            if (nowPos - 1 >= 0 && !VISITED[nowPos - 1]) {
                deque.offerLast(new Node(nowPos - 1, nowTime + 1));
            }
            if (nowPos + 1 <= 100000 && !VISITED[nowPos + 1]) {
                deque.offerLast(new Node(nowPos + 1, nowTime + 1));
            }
        }

        return -1;
    }

    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

}