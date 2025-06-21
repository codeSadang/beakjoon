package class4.풀어야할문제.트리의부모찾기_11725_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static List<List<Integer>> NODE_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            NODE_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[N + 1];

        for (int i = 1; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            NODE_LIST.get(u).add(v);
            NODE_LIST.get(v).add(u);
        }
        System.out.println(NODE_LIST);

        dfs();
    }

    private static void dfs() {
        Stack<Integer> stack = new Stack<>();
    }

}