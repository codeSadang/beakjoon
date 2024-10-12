package 너비우선탐색.풀어야할문제.촌수계산_2644_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {
    static List<List<Integer>> family;
    static boolean[] visited;
    static int N, targetA, targetB, count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken()) - 1;
        targetB = Integer.parseInt(st.nextToken()) - 1;

        count = Integer.parseInt(br.readLine());

        family = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            family.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            family.get(u-1).add(v-1);
            family.get(v-1).add(u-1);
        }
        System.out.println(bfs());
    }


    static int bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{targetA, 0});
        visited[targetA] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int currNum = curr[0];
            int currDepth = curr[1];
            if(currNum == targetB) {
                return currDepth;
            }

            for (int now : family.get(currNum)) {
                if(!visited[now]) {
                    visited[now] = true;
                    queue.add(new int[]{now, currDepth + 1});
                }
            }
        }

        return -1;

    }
}
