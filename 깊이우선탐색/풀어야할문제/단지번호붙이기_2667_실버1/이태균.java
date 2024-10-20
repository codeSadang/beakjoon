package 깊이우선탐색.풀어야할문제.단지번호붙이기_2667_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이태균 {

    public static int N;

    public static int[][] TOWN;
    public static boolean[][] VISITED;

    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static int COUNT;
    public static List<Integer> COMPLEX = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 초기화
        N = Integer.parseInt(br.readLine());
        TOWN = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                TOWN[i][j] = Integer.parseInt(str[j]);
            }
        }
        // 방문 여부 초기화
        VISITED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j] && TOWN[i][j] == 1) {
                    COUNT = 0;
                    dfs(i, j);

                    COMPLEX.add(COUNT);
                }
            }
        }

        System.out.println(COMPLEX.size());

        Collections.sort(COMPLEX);
        COMPLEX.forEach(System.out::println);
    }

    private static void dfs(int now_row, int now_col) {
        VISITED[now_row][now_col] = true;
        COUNT++;

        for (int i = 0; i < 4; i++) {
            int next_row = now_row + DX[i];
            int next_col = now_col + DY[i];

            if (next_row < N && next_col < N && next_row >= 0 && next_col >= 0 && !VISITED[next_row][next_col]) {
                if (TOWN[next_row][next_col] == 1) {
                    dfs(next_row, next_col);
                }
            }
        }
    }

}