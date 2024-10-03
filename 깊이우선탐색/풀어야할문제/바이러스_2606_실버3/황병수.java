package 깊이우선탐색.풀어야할문제.바이러스_2606_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static List<List<Integer>> tree; // 그래프를 인접 리스트로 표현
    static boolean[] visited; // 방문 여부를 기록하는 배열
    static int count = 0; // 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // // 직접 연결된 쌍의 수

        tree = new ArrayList<>(); // 1번부터 n번 컴퓨터까지 사용 (0번 인덱스는 사용하지 않음)
        visited = new boolean[n + 1]; // 방문 여부 기록 (1번부터 n번 컴퓨터까지)

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u); // 양방향 그래프이므로 양쪽에 추가
        }

        // 1번 컴퓨터에서 시작
        dfs(1);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터 수 출력
        System.out.println(count - 1);
    }

    // 깊이 우선 탐색 (DFS) 함수
    static void dfs(int current) {
        visited[current] = true;
        count++; // 방문할 때마다 감염된 컴퓨터 수 증가

        // 인접한 컴퓨터들에 대해 DFS 호출
        for (int neighbor : tree.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
