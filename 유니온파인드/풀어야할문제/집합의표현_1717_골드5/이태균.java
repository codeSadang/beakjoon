package 유니온파인드.풀어야할문제.집합의표현_1717_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] parent;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(node1, node2);
            } else {
                SB.append(isConnected(node1, node2) ? "YES\n" : "NO\n");
            }
        }

        System.out.println(SB.toString());
    }

    private static int find(int node) {
        if (node != parent[node]) {
            return parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private static void union(int node1, int node2) {
        int rootX = find(node1);
        int rootY = find(node2);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    private static boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

}