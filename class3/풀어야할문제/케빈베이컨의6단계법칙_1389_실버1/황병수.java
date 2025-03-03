package class3.풀어야할문제.케빈베이컨의6단계법칙_1389_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 지구의 모든 사람은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
 * 임의의 두 사람이 최소 몇 단계 만에 이어질 . 있는지 계산
 */
public class 황병수 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int resultNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());

            graph[friendA].add(friendB);
            graph[friendB].add(friendA);
        }

        for (int i = N; i >= 1; i--) {
            bfs(i);
        }

        System.out.println(resultNum);
    }

    private static void bfs(int start) {
        Arrays.fill(visited, false);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        int sum = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now = poll[0];
            int depth = poll[1];

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                    sum += depth + 1;
                }
            }
        }

        if (sum <= result) {
            result = sum;
            resultNum = start;
        }
    }
}
