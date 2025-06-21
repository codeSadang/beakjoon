package 백트래킹.풀어야할문제.N과M1_15649_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static int[] ARR;
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[N];
        VISITED = new boolean[N];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        for (int i = 0; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = i + 1;
                backtracking(depth + 1);
                VISITED[i] = false;
            }
        }
    }

}