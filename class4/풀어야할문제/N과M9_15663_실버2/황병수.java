package class4.풀어야할문제.N과M9_15663_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {
    static int N, M;
    static int[] sequence;
    static ArrayList<Integer> sortedList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sortedList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sortedList.add(Integer.parseInt(st.nextToken()));
        }

        sortedList.sort(Comparator.naturalOrder());
        sequence = new int[M];
        visited = new boolean[N];

        backtrack(0);
    }

    private static void backtrack(int depth) {
        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = 0; i < sortedList.size(); i++) {
            if (visited[i] || sortedList.get(i) == prev) continue;

            sequence[depth] = sortedList.get(i);
            visited[i] = true;
            prev = sortedList.get(i);

            backtrack(depth + 1);
            visited[i] = false;
        }
    }
}