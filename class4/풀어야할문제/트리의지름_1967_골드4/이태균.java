package class4.풀어야할문제.트리의지름_1967_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static List<List<Node>> NODE_LIST = new ArrayList<>();
    public static boolean[] VISITED;
    public static int maxDistance;
    public static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            NODE_LIST.get(u).add(new Node(v, c));
            NODE_LIST.get(v).add(new Node(u, c));
        }

        // 1단계: 임의의 노드(1번)에서 가장 먼 노드 찾기
        VISITED = new boolean[N + 1];
        maxDistance = 0;
        farthestNode = 1;
        dfs(1);

        // 2단계: 가장 먼 노드에서 다시 가장 먼 노드 찾기
        VISITED = new boolean[N + 1];
        maxDistance = 0;
        dfs(farthestNode);

        System.out.println(maxDistance);
    }

    private static void dfs(int start) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(start, 0));
        VISITED[start] = true;

        while (!stack.isEmpty()) {
            Node now = stack.pop();
            int now_end = now.end;
            int now_cost = now.cost;

            // 현재 노드가 가장 먼 거리라면 업데이트
            if (now_cost > maxDistance) {
                maxDistance = now_cost;
                farthestNode = now_end;
            }

            for (Node next : NODE_LIST.get(now_end)) {
                if (!VISITED[next.end]) {
                    VISITED[next.end] = true;
                    stack.push(new Node(next.end, now_cost + next.cost));
                }
            }
        }
    }

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}