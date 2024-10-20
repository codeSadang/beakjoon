package 깊이우선탐색.풀어야할문제.바이러스_2606_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int COMPUTER_SIZE;
    public static int LINKED_COMPUTER_SIZE;

    public static List<List<Integer>> COMPUTER_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // pc 개수
        COMPUTER_SIZE = Integer.parseInt(br.readLine());
        // 연결된 pc 수
        LINKED_COMPUTER_SIZE = Integer.parseInt(br.readLine());

        // 컴퓨터 리스트 초기화 (1번부터 시작이므로 0번 인덱스는 사용하지 않음)
        for (int i = 0; i <= COMPUTER_SIZE; i++) {
            COMPUTER_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[COMPUTER_SIZE + 1];

        // 네트워크 상 pc 상태
        for (int i = 0; i < LINKED_COMPUTER_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결
            COMPUTER_LIST.get(u).add(v);
            COMPUTER_LIST.get(v).add(u);
        }

        dfs(1);

        System.out.println(COUNT);
    }

    private static void dfs(int idx) {
        VISITED[idx] = true;

        if (idx != 1) {
            COUNT++;
        }

        // 연결된 컴퓨터들에 대해 재귀적으로 DFS 수행
        for (Integer linkedId : COMPUTER_LIST.get(idx)) {
            if (!VISITED[linkedId]) {
                dfs(linkedId);
            }
        }
    }

}