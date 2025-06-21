package 너비우선탐색.풀어야할문제.촌수계산_2644_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N;
    public static int TARGET;
    public static int TARGET2;
    public static int M;

    public static List<List<Integer>> FAMILY_LIST;
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가족 인원 수
        N = Integer.parseInt(br.readLine());
        // 가족 구성도 초기화
        FAMILY_LIST = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            FAMILY_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[N + 1];

        // 구해야 할 촌수 대상 가족
        StringTokenizer st = new StringTokenizer(br.readLine());
        TARGET = Integer.parseInt(st.nextToken());
        TARGET2 = Integer.parseInt(st.nextToken());

        // 부모-자식 관의 관계의 갯수
        M = Integer.parseInt(br.readLine());

        // 부모 자식간의 관계
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            FAMILY_LIST.get(v).add(u);
            FAMILY_LIST.get(u).add(v);
        }

        // BFS 탐색 시작 (시작 위치[인덱스] : 1)
        bfs(1);
    }

    // BFS 구현
    private static int bfs(int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        // 큐에 시작점을 저장
        q.add(new int[]{idx});
        // 시작점 방문 처리
        VISITED[idx] = true;

        while (!q.isEmpty()) {

        }

        return -1;
    }

}