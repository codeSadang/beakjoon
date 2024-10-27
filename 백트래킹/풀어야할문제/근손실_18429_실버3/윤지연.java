package 백트래킹.풀어야할문제.근손실_18429_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int K;
    static int base = 500;
    static int result = 0;
    static int[] kit;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 1. 입력처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        // 운동키트 입력
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(500, 0);

        System.out.println(result);
    }

    public static void backtrack(int todayWeight, int count) {
        if (count == N) {
            result++;
            return;
        }

        if (todayWeight < base) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(todayWeight - K + kit[i], count + 1);
                visited[i] = false;
            }
        }
    }
}
