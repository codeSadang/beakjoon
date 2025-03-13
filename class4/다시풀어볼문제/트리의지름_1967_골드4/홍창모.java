package class4.다시풀어볼문제.트리의지름_1967_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홍창모 {
    static int N, answer = 0, farthestNode = 0;

    static StringTokenizer st;
    static List<Node>[] tree;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for( int i = 0; i < N-1; i++ ) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[N+1];
        farthestNode = 1;
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(farthestNode, 0);
        dfs(farthestNode, 0);

        System.out.println(answer);

    }

    private static void dfs(int idx, int sum) {
        visited[idx] = true;

        if( sum > answer ) {
            answer = sum;
            farthestNode = idx;
        }

        for( Node node : tree[idx] ) {
            if( !visited[node.idx] ) {
                dfs(node.idx, sum + node.weight);
            }
        }
    }

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}
