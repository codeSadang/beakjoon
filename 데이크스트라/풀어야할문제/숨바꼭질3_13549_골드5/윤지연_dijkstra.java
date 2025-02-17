package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 윤지연_dijkstra {

  /*
  * 순간이동:
  * 걷기+:
  * 걷기-:
  * distance - 각 위치까지 최소 시간 저장
  * */

    public static final int MAX = 100001;

    static int n, k;
    static int[] distance;
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

        n = Integer.parseInt(st.nextToken()); // 수빈 시작점
        k = Integer.parseInt(st.nextToken()); // 수빈 도착점(동생)

        distance = new int[MAX];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[n] = 0;

        System.out.println(dijkstra(n));
    }

    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.position == k) return cur.time;
            if (distance[cur.position] < cur.time) continue;

            // 순간이동
            if (cur.position * 2 < MAX && distance[cur.position * 2] > cur.time) {
                distance[cur.position * 2] = cur.time;
                pq.add(new Node(cur.position * 2, cur.time));
            }

            // 뒤로 걷기
            if (cur.position - 1 >= 0 && distance[cur.position - 1] > cur.time + 1) {
                distance[cur.position - 1] = cur.time + 1;
                pq.add(new Node(cur.position - 1, cur.time + 1));
            }

            // 앞으로 걷기
            if (cur.position + 1 < MAX && distance[cur.position + 1] > cur.time + 1) {
                distance[cur.position + 1] = cur.time + 1;
                pq.add(new Node(cur.position + 1, cur.time + 1));
            }
        }

        return -1;
    }
}
