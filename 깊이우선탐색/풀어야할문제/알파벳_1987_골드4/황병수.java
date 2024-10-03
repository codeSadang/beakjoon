package 깊이우선탐색.풀어야할문제.알파벳_1987_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 황병수 {

    static String[][] map;
    static boolean[][] visited;
    static int C;
    static int R;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashMap<String, Integer> alphabetMap;
    static int maxCnt = Integer.MIN_VALUE;
    static int nowCnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 초기화
        map = new String[R][C];
        visited = new boolean[R][C];
        alphabetMap = new HashMap<>();

        // 값 할당
        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().split("");
        }

        // 조회
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited = new boolean[R][C];
                alphabetMap = new HashMap<>();
                nowCnt = 0;
                dfs(i, j, 1);
                maxCnt = Math.max(nowCnt, maxCnt);
            }
        }
        System.out.println(maxCnt);
    }

    static void dfs(int y, int x, int cnt) {
        // 최대 카운트 업데이트
        maxCnt = Math.max(maxCnt, cnt);
        visited[y][x] = true;


        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx >= 0 && ny >= 0 &&  nx < C && ny < R) {
                if (!visited[ny][nx] && processColor(map[ny][nx])) {
                    dfs(ny, nx, cnt + 1);
                }
            }
        }
    }

    static boolean processColor(String color) {
        int count = alphabetMap.getOrDefault(color, 0);

        if (count == 0) {
            alphabetMap.put(color, 1);
            return true;
        } else {
            return false;
        }
    }
}
