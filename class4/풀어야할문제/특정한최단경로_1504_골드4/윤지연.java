package class4.풀어야할문제.특정한최단경로_1504_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 윤지연 {
    static int N,E;
    static int v1,v2;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static final int INF = 200000000;

    static class Node implements Comparable<Node> {
        int end;
        int weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s1[0]);
        E = Integer.parseInt(s1[1]);

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프
        for (int i = 0; i < E; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            // 양방향 그래프라 양쪽 모두 추가함
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        // 필수 정점 입력
        String[] s3 = br.readLine().split(" ");
        v1 = Integer.parseInt(s3[0]);
        v2 = Integer.parseInt(s3[1]);

        // 경로별 거리 계산
        int path1_1 = dijkstra(1, v1);
        int path1_2 = dijkstra(v1, v2);
        int path1_3 = dijkstra(v2, N);

        int path2_1 = dijkstra(1, v2);
        int path2_2 = dijkstra(v2, v1);
        int path2_3 = dijkstra(v1, N);

        long path1 = path1_1 == -1 || path1_2 == -1 || path1_3 == -1 ? INF :
                (long)path1_1 + path1_2 + path1_3;
        long path2 = path2_1 == -1 || path2_2 == -1 || path2_3 == -1 ? INF :
                (long)path2_1 + path2_2 + path2_3;

        long answer = Math.min(path1, path2);

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static int dijkstra(int start, int end) {
        // 거리 배열 초기화
        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        // 모든 노드 방문하기 반복
        while (!pq.isEmpty()) {
            // 현재 가장 가까운 노드 정보 가져오기
            Node cur = pq.poll();
            int now = cur.end; // 현재 노드
            int dist = cur.weight; // 시작 - 현재 거리
            // 이미 처리된 노드 스킵
            if (distance[now] < dist ) {
                continue;
            }
            // 현재 노드와 연결된 다른 노드 확인
            for (Node next: graph.get(now)) {
                // 다음 노드로 가는 새로운 거리 계산
                int nextDist = distance[now] + next.weight;
                // 새로운 거리가 기존 거리보다 짧으면 업데이트
                if (nextDist < distance[next.end]) {
                    distance[next.end] = nextDist;
                    pq.offer(new Node(next.end, nextDist));
                }
            }
        }
        // 도착점까지 최단 거리 반환
        return distance[end] == Integer.MAX_VALUE ? -1 : distance[end];
    }
}
