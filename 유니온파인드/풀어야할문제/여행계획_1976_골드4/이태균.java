package 유니온파인드.풀어야할문제.여행계획_1976_골드4;

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
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int node1 = 1; node1 <= N; node1++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == 1) {
                    union(node1, node2);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int national1 = Integer.parseInt(st.nextToken());
        int national2 = Integer.parseInt(st.nextToken());
        int national3 = Integer.parseInt(st.nextToken());

        if (find(national1) == find(national2) && find(national2) == find(national3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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