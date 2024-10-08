package 깊이우선탐색.풀어야할문제.DFS와BFS_1260_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 황병수 {

    static int pointCnt;
    static int qCnt;
    static int startPoint;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static List<Integer> dfsList;
    static List<Integer> bfsList;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        

        // 값 넣기
        StringTokenizer st = new StringTokenizer(bf.readLine());
        pointCnt = Integer.parseInt(st.nextToken());
        qCnt = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(st.nextToken());

        //초기화
        visited = new boolean[pointCnt + 1];
        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();
        tree = new ArrayList<>();

        for (int i = 0; i <= pointCnt; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        for (int i = 0; i <= pointCnt; i++) {
            Collections.sort(tree.get(i));
        }

        dfs(startPoint);

        // 초기화
        visited = new boolean[pointCnt + 1];
        bfs(startPoint);

        System.out.println(dfsList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        System.out.println(bfsList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    static void dfs(int curr) {
        visited[curr] = true;
        dfsList.add(curr);

        for (int now : tree.get(curr)) {
            if(!visited[now]) {
                dfs(now);
            }
        }
    }

    static void bfs(int curr) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(curr);
        visited[curr] = true;

        while (!deque.isEmpty()) {
            int current = deque.poll();
            bfsList.add(current);

            for (int neighbor : tree.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    deque.add(neighbor);
                }
            }
        }
    }
}
