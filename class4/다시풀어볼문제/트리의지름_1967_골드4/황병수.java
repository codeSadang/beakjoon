package class4.다시풀어볼문제.트리의지름_1967_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static int N;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));  // 트리는 양방향 그래프

        }

        // 루트 노드에서 가장 먼 거리
        visited = new boolean[N+1];
        dfs(1,0);


        // 가장 먼 노드에서 가장 먼 노드 구하기
        maxDist = 0;
        visited = new boolean[N+1];
        dfs(farthestNode,0);

        System.out.println(maxDist);

    }

    private static void dfs(int end, int value) {
        ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.addFirst(new Node(end, value));
        while (!stack.isEmpty()) {

            Node node = stack.pollFirst();
            int nowEnd = node.end;
            int nowValue = node.value;

            if (visited[nowEnd]) continue;
            visited[nowEnd] = true;

            if (nowValue > maxDist) {
                maxDist = nowValue;
                farthestNode = nowEnd;
            }

            for (Node next : tree[nowEnd]) {
                if(!visited[next.end]) {
                    stack.addFirst(new Node(next.end, next.value + nowValue));
                }
            }


        }

    }


    static class Node {
        int end, value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

    }
}
