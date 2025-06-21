package 깊이우선탐색.풀어야할문제.양_3184_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int R;
    public static int C;

    public static String[][] YARD;
    public static boolean[][] VISITED;

    // 마당 내 영역 확인
    public static List<int[]> FIELD_LIST = new ArrayList<>();

    // 1) 상하좌우 이동가능한 방향성 선언
    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 마당 크기 선언 R : 행 C : 열
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        YARD = new String[R][C];
        for (int i = 0; i < R; i++) {
            YARD[i] = br.readLine().split("");
        }
        // 방문 여부 초기화 default : false
        VISITED = new boolean[R][C];

        // dfs 시작
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 필드 구분을 위한 방문여부 체크
                if (!VISITED[i][j]) {
                    dfs(i, j, 0, 0);
                }
            }
        }
    }

    private static void dfs(int now_row, int now_col, int o, int v) {
        VISITED[now_row][now_col] = true;
        String now_yard = YARD[now_row][now_col];

        // 현재 울타리면 탈출
        if (now_yard.equals("#")) {
            return;
        }
        // 양인지 늑대인지 확인
        if (now_yard.equals("o")) {
            o++;
        }
        if (now_yard.equals("v")) {
            v++;
        }

        // 해당 필드에서 상하좌우로 이동하며 dfs 실행
        for (int i = 0; i < 4; i++) {
            // 방문한 마당 확인
            int next_row = now_row + DX[i];
            int next_col = now_col + DY[i];

            // 상하좌우 이동 시 마당에서 탈출이 불가능하며, 이미 방문한 필드는 넘어감
            if (next_row < R && next_col < C && next_row >= 0 && next_col >= 0 && !VISITED[next_row][next_col]) {
                dfs(next_row, next_col, o, v);
            }

        }
    }

}