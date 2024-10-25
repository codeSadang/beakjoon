package 백트래킹.풀어야할문제.차이를최대로_10819_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 황병수 {

    static int N;
    static int[] list;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new int[N];
        visited = new boolean[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(split[i]);
        }

        backtracking(0, new ArrayList<>());
        System.out.println(result);
    }

    private static void backtracking(int count, List<Integer> selected) {

        if (N == count) {
            calculator(selected);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected.add(list[i]);
                backtracking(count + 1, selected);

                visited[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }

    private static void calculator(List<Integer> selected) {
        int tempResult = 0;
        for (int i = 0; i < N-1; i++) {
            tempResult += Math.abs(selected.get(i) - selected.get(i + 1));
        }

        result = Math.max(result, tempResult);
    }
}
