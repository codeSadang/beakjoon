package 깊이우선탐색.풀어야할문제.바이러스_2606_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int COMPUTER_SIZE;
    public static int LINKED_SIZE;
    public static List<List<Integer>> COMPUTER_LIST = new ArrayList<>();
    public static boolean[] VISITED;
    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        COMPUTER_SIZE = Integer.parseInt(br.readLine());
        LINKED_SIZE = Integer.parseInt(br.readLine());

        // 그래프 초기화 (1번부터 시작)
        for (int i = 0; i <= COMPUTER_SIZE; i++) {
            COMPUTER_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[COMPUTER_SIZE + 1];

        // 그래프 입력 (양방향 연결)
        for (int i = 0; i < LINKED_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            COMPUTER_LIST.get(u).add(v);
            COMPUTER_LIST.get(v).add(u);
        }

        dfs();

        System.out.println(COUNT);
    }

    private static void dfs() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        VISITED[1] = true;

        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (Integer next : COMPUTER_LIST.get(now)) {
                if (!VISITED[next]) {
                    stack.push(next);
                    VISITED[next] = true;
                    COUNT++;
                }
            }
        }
    }
}