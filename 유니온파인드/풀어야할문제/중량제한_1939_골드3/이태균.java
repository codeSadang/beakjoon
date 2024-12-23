package 유니온파인드.풀어야할문제.중량제한_1939_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] PARENT;

    public static List<int[]> BRIDGE_LIST = new ArrayList<>();

    public static int LAST_FACTORY_ISLAND_1;
    public static int LAST_FACTORY_ISLAND_2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PARENT = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            PARENT[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int toIsland = Integer.parseInt(st.nextToken());
            int fromIsland = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            BRIDGE_LIST.add(new int[]{toIsland, fromIsland, weight});
        }

        st = new StringTokenizer(br.readLine());
        LAST_FACTORY_ISLAND_1 = Integer.parseInt(st.nextToken());
        LAST_FACTORY_ISLAND_2 = Integer.parseInt(st.nextToken());

        BRIDGE_LIST.sort((e1, e2) -> e2[2] - e1[2]);

        for (int[] BRIDGE : BRIDGE_LIST) {
            union(BRIDGE[0], BRIDGE[1]);

            if (find(LAST_FACTORY_ISLAND_1) == find(LAST_FACTORY_ISLAND_2)) {
                System.out.println(BRIDGE[2]);
                return;
            }
        }

    }

    private static int find(int node) {
        if (node != PARENT[node]) {
            return PARENT[node] = find(PARENT[node]);
        }
        return PARENT[node];
    }

    private static void union(int node, int node2) {
        int rootX = find(node);
        int rootY = find(node2);

        if (rootX != rootY) {
            PARENT[rootY] = rootX;
        }
    }

}