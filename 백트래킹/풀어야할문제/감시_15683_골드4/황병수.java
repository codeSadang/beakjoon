package 백트래킹.풀어야할문제.감시_15683_골드4;


/**
 * 0 : 빈칸
 * 1 ~ 5 : 카메라
 * 6 : 벽
 *
 * 1 : 1방향
 * 2 : 양방향 (정반대)
 * 3 : 90도
 * 4 : 3방향
 * 5 : 4방향 모두
 *
 * cctv는 다른 cctv를 통과할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.StringTokenizer;

/**
 * 각 cctv 마다
 */
public class 황병수 {
    static int N,M;
    static boolean[][] visited;
    static ArrayList<int[]> cctvs = new ArrayList<>(); // cctv의 좌표와 종류 저장
    static int[][] map;
    static int hiddenPlaceCnt = 0;
    static int minResult = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, map[i][j]}); // cctv 좌표와 번호 저장
                }
            }
        }

        backtracking(0);

    }

    private static void backtracking(int index) {

        if (index == cctvs.size()) {
            minResult = Math.min(minResult, countBlindSpot());
            return;
        }

        int[] cctv = cctvs.get(index); // 현재 탐색하는 cctv 정보 (좌표와 번호)
        int y = cctv[0];
        int x = cctv[1];
        int type = cctv[2];
    }

    private static void checkingFirst(int y, int x) {


        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            boolean stop = true;
            while (stop) {
                ny += dy[i];
                nx += dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] != 6) {
                    visited[ny][nx] = true;

                } else {
                    stop = false;
                }
            }
        }

    }
    private static void checkingSecond(int y, int x) {

    }
    private static void checkingThird(int y, int x) {

    }
    private static void checkingForth(int y, int x) {

    }
    private static void checkingFifth(int y, int x) {

    }

    static int countBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
