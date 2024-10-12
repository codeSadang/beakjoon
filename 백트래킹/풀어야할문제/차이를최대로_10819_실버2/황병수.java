package 백트래킹.풀어야할문제.차이를최대로_10819_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());



        visited = new boolean[N];
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, new ArrayList<>());

        System.out.println(maxValue);
    }

    static void dfs(int depth, List<Integer> result) {
        if (N == depth) {
            int calcValue = 0;
            for (int i = 0; i < result.size() - 1; i++) {
                calcValue += Math.abs(result.get(i) - result.get(i+1));
            }
            maxValue = Math.max(calcValue, maxValue);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(numbers[i]);
                dfs(depth + 1, result);


                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }

    }
}
