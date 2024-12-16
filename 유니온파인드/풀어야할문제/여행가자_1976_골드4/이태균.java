package 유니온파인드.풀어야할문제.여행가자_1976_골드4;

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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int command = Integer.parseInt(st.nextToken());
                if (command == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int national = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int national2 = Integer.parseInt(st.nextToken());
            if (national != find(national2)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
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

}