package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이태균_데이크스트라 {

    public static int N;
    public static int K;
    public static int[] DISTANCE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        DISTANCE_LIST = new int[100001];
        Arrays.fill(DISTANCE_LIST, Integer.MAX_VALUE);

        int result = dijkstra(N, K);
        System.out.println(result);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Node(start, 0));
        DISTANCE_LIST[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowPos = now.pos;
            int nowTime = now.time;

            if (nowPos == end) {
                return nowTime;
            }

            if (nowTime > DISTANCE_LIST[nowPos]) {
                continue;
            }

            if (nowPos * 2 <= 100000) {
                if (DISTANCE_LIST[nowPos * 2] > nowTime) {
                    DISTANCE_LIST[nowPos * 2] = nowTime;
                    pq.offer(new Node(nowPos * 2, nowTime));
                }
            }
            if (nowPos - 1 >= 0) {
                if (DISTANCE_LIST[nowPos - 1] > nowTime + 1) {
                    DISTANCE_LIST[nowPos - 1] = nowTime + 1;
                    pq.offer(new Node(nowPos - 1, nowTime + 1));
                }
            }
            if (nowPos + 1 <= 100000) {
                if (DISTANCE_LIST[nowPos + 1] > nowTime + 1) {
                    DISTANCE_LIST[nowPos + 1] = nowTime + 1;
                    pq.offer(new Node(nowPos + 1, nowTime + 1));
                }
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