package 해시.풀어야할문제.친구네트워크_4195_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int F;
    public static int[] PARENT;
    public static int[] LEVEL;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            PARENT = new int[F * 2];
            LEVEL = new int[F * 2];

            for (int j = 0; j < F * 2; j++) {
                PARENT[j] = j;
                LEVEL[j] = 1;
            }

            int index = 0;
            for (int k = 0; k < F; k++) {
                st = new StringTokenizer(br.readLine());
                String to = st.nextToken();
                String from = st.nextToken();

                if (!map.containsKey(to)) {
                    map.put(to, index++);
                }
                if (!map.containsKey(from)) {
                    map.put(from, index++);
                }

                int root1 = find(map.get(to));
                int root2 = find(map.get(from));

                if (root1 != root2) {
                    union(root1, root2);
                }

                SB.append(LEVEL[find(root1)]).append("\n");
            }
        }

        System.out.print(SB.toString());
    }

    private static void union(int root, int root2) {
        int rootX = find(root);
        int rootY = find(root2);

        if (rootX != rootY) {
            PARENT[rootY] = rootX;
            LEVEL[rootX] += LEVEL[rootY];
        }
    }

    private static int find(int root) {
        if (root != PARENT[root]) {
            PARENT[root] = find(PARENT[root]);
        }

        return PARENT[root];
    }

}