package 깊이우선탐색.풀어야할문제.알파벳_1987_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * DFS, 백트래킹
 */
public class 황병수 {

    static int[][] map;
    static boolean[] visit = new boolean[26];
    static int C, R;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxCnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 초기화
        map = new int[R][C];

        // 값 할당
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        // 조회
        dfs(0, 0, 0);

        // 출력
        System.out.println(maxCnt);
    }

    public static void dfs(int x, int y, int count) {
        if (visit[map[x][y]]) { // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
            count++;
            maxCnt = Math.max(maxCnt, count); // 정답을 갱신해준다.

        } else {
            visit[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                    dfs(cx, cy, count);
                }
            }

            visit[map[x][y]] = false;

        }
    }
}
