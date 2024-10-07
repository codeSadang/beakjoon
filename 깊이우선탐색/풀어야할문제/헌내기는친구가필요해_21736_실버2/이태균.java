package 깊이우선탐색.풀어야할문제.헌내기는친구가필요해_21736_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static char[][] CAMPUS;
    public static boolean[][] VISITED;

    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static int COL;
    public static int ROW;
    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 캠퍼스 셋팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CAMPUS = new char[N][M];
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] split = str.split("");
            for (int j = 0; j < M; j++) {
                CAMPUS[i][j] = split[j].charAt(0);

                if (CAMPUS[i][j] == 'I') {
                    ROW = i;
                    COL = j;
                }
            }
        }

        dfs(ROW, COL);

        if (COUNT == 0) {
            System.out.print("TT");
        } else {
            System.out.println(COUNT);
        }
    }

    private static void dfs(int y, int x) {
        // 현재 캠퍼스 위치 방문
        VISITED[y][x] = true;

        if (CAMPUS[y][x] == 'P') {
            COUNT++;
        }

        // 상하좌우로 캠퍼스 탐색
        for (int i = 0; i < 4; i++) {
            int c_y = y + DY[i];
            int c_x = x + DX[i];

            if (c_x >= 0 && c_x < M && c_y >= 0 && c_y < N) {
                if (!VISITED[c_y][c_x] && (CAMPUS[c_y][c_x] != 'X')) {
                    dfs(c_y, c_x);
                }

            }
        }
    }

}