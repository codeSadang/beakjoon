package 깊이우선탐색.풀어야할문제.바이러스_2606_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {

    static int COMPUTER, CONNECT, ANSWER;
    static boolean[] VISITED;
    static List<Integer>[] GRAPH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터의 총 개수
        COMPUTER = Integer.parseInt(br.readLine());
        // 연결된 컴퓨터의 개수
        CONNECT = Integer.parseInt(br.readLine());

        VISITED = new boolean[COMPUTER + 1];
        GRAPH = new ArrayList[COMPUTER + 1];

        // 그래프 초기화
        for (int i = 1; i <= COMPUTER; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < CONNECT; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            GRAPH[a].add(b);
            GRAPH[b].add(a);
        }

        // DFS 시작
        dfs(1);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터 수 출력
        System.out.println(ANSWER - 1);
    }

    static void dfs(int start) {
        VISITED[start] = true;
        ANSWER++; // 방문한 컴퓨터 수 증가

        for (int next : GRAPH[start]) {
            if (!VISITED[next]) {
                dfs(next);
            }
        }
    }
}