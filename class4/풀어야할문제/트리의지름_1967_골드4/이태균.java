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
    public static int RESULT = 0;

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

        for (int i = 1; i <= N; i++) {
            VISITED = new boolean[N + 1];
            dfs(i, 0);
        }

        System.out.println(RESULT);
    }

    private static void dfs(int start, int sum) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(start, sum));
        VISITED[start] = true;

        while (!stack.isEmpty()) {
            Node now = stack.pop();
            int now_end = now.end;
            int now_cost = now.cost;

            RESULT = Math.max(now_cost, RESULT);

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