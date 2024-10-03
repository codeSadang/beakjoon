package 깊이우선탐색.풀어야할문제.촌수계산_2644_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static List<List<Integer>> tree;
    static boolean[] visited;
    static int peopleCnt;
    static int QCnt;
    static int targetA;
    static int targetB;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 전체 가족 수
        peopleCnt = Integer.parseInt(bf.readLine());

        // A, B 각각 넘버
        StringTokenizer st = new StringTokenizer(bf.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());

        // 앞으로 나올 조건 수
        QCnt = Integer.parseInt(bf.readLine());

        tree = new ArrayList<>();
        visited = new boolean[peopleCnt+1];

        for (int i = 0; i <= peopleCnt; i++) {
            tree.add(new ArrayList<>());
        }

        // 인접리스트 작성
        for (int i = 0; i < QCnt; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(targetA, 0);

        System.out.println("result = " + result);

    }

    static void dfs(int current, int depth) {
        visited[current] = true;
        // 종료 조건: targetB에 도달하면 결과를 저장
        if (current == targetB) {
            result = depth;  // 깊이를 결과로 저장
            return;
        }

        // 인접한 컴퓨터들에 대해 DFS 호출
        for (int neighbor : tree.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
            }
        }
    }
}
