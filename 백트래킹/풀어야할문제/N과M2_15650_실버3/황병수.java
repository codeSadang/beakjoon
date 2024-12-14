package 백트래킹.풀어야할문제.N과M2_15650_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static boolean[] visited;

    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
    }

    static void dfs(int depth) {
       if(depth == M) {
           for (int val : arr) {
               System.out.print(val + " ");
           }
           System.out.println();
           return;
       }

        for (int i = 1; i < N; i++) {
            if (!visited[i] ) {
                if (depth > 0) {
                    if (arr[depth-1] < (i + 1)) {
                        visited[i] = true;
                        arr[depth] = i + 1;
                        dfs(depth + 1);

                        visited[i] = false;
                    }
                } else {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1);

                    visited[i] = false;
                }

            }
        }
    }
}
