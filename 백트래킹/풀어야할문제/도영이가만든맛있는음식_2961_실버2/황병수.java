package 백트래킹.풀어야할문제.도영이가만든맛있는음식_2961_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int N;
    static int[][] ingredients;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        ingredients = new int[N][2];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        bfs(0);

        System.out.println(minValue);
    }

    static void bfs(int cnt) {

        if (cnt == N) {
            minValue = Math.min(minValue, getTaste());
            return;
        }

        visited[cnt] = true;
        bfs(cnt+1);

        visited[cnt] = false;
        bfs(cnt+1);
    }

    static int getTaste() {
        int bitter = 0;
        int sour = 1;
        for(int i=0; i<N; i++) {
            if(visited[i]) {
                bitter += ingredients[i][1];
                sour *= ingredients[i][0];
            }
        }
        if(bitter == 0 && sour == 1) return Integer.MAX_VALUE;

        return Math.abs(bitter - sour);
    }
}
