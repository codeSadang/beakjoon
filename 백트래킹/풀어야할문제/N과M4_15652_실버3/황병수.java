package 백트래킹.풀어야할문제.N과M4_15652_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static boolean[] visited;
    static int[] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];


        dfs(0, 1);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
       if(depth == M) {
           for (int val : arr) {
               sb.append(val).append(' ');
           }
           sb.append('\n');
           return;
       }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
