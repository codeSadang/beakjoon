package class3.풀어야할문제.연결요소의개수_11724_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를구하시오
 */
public class 황병수 {

    static int N,M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int index) {
        visited[index] = true;

        for (int next : graph[index]) {
            if (!visited[next]) {
                bfs(next);
            }
        }
    }
}
