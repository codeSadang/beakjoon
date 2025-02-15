package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        VISITED[start] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowPos = now.pos;
            int nowTime = now.time;

            if (nowPos == end) {
                return nowTime;
            }

            if (nowPos * 2 <= 100001 && !VISITED[nowPos * 2]) {
                VISITED[nowPos * 2] = true;
                queue.offer(new Node(nowPos * 2, nowTime));
            }
            if (nowPos - 1 >= 0 && !VISITED[nowPos - 1]) {
                VISITED[nowPos - 1] = true;
                queue.offer(new Node(nowPos - 1, nowTime + 1));
            }
            if (nowPos + 1 <= 100001 && !VISITED[nowPos + 1]) {
                VISITED[nowPos + 1] = true;
                queue.offer(new Node(nowPos + 1, nowTime + 1));
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