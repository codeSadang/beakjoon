package 유니온파인드.풀어야할문제.사이클게임_20040_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if (find(node1) == find(node2)) {
                result = i + 1;
                return;
            } else {
                union(node1, node2);
            }
        }

        System.out.println(result);
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

    private static void isUnion(int node1, int node2) {

    }

}