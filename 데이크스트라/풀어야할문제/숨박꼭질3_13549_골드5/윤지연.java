package 데이크스트라.풀어야할문제.숨박꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 윤지연 {

  /*
  * 순간이동:
  * 걷기+:
  * 걷기-: */
    public static final int MAX = 100001;

    static class Node implements Comparable<Node> {
        int position, time;

        Node(int p, int t) {
            this.position = p;
            this.time = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈 시작점
        int k = Integer.parseInt(st.nextToken()); // 수빈 도착점(동생)

        int[] distance = new int[MAX];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[n] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(n, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

        }


        // bfs, dikjstra,
    }

}
