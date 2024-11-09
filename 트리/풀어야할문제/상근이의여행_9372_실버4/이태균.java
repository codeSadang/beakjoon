package 트리.풀어야할문제.상근이의여행_9372_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int N;
    public static int M;
    public static List<List<Integer>> AIRPLANE_LIST;
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            AIRPLANE_LIST = new ArrayList<>();
            VISITED = new boolean[N + 1];

            for (int j = 0; j <= N; j++) {
                AIRPLANE_LIST.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                AIRPLANE_LIST.get(u).add(v);
                AIRPLANE_LIST.get(v).add(u);
            }

            int result = dfs(1, 0);
            System.out.println(result);
        }
    }

    private static int dfs(int now, int count) {
        VISITED[now] = true;

        for (int next : AIRPLANE_LIST.get(now)) {
            if (!VISITED[next]) {
                count = dfs(next, count + 1);
            }
        }

        return count;
    }
}