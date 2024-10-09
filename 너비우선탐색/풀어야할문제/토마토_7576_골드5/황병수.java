package 너비우선탐색.풀어야할문제.토마토_7576_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static int ROW, COLUMN;
    static int UNRIPETOMATO = 0;
    static int RIPETOMATO = 0;
    static int RESULT;
    static int[][] MAP;
    static boolean[][] VISITED;
    static boolean[][] RIPED;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COLUMN = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());
        MAP = new int[ROW][COLUMN];
        VISITED = new boolean[ROW][COLUMN];
        RIPED = new boolean[ROW][COLUMN];
        RESULT = 0;

        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COLUMN; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());

                if (MAP[i][j] == 1) {
                    RIPETOMATO += 1;
                }

                if (MAP[i][j] == 0) {
                    UNRIPETOMATO += 1;
                }
            }
        }

//        System.out.println("UNRIPETOMATO = " + UNRIPETOMATO);
//        System.out.println("RIPETOMATO = " + RIPETOMATO);

        while (UNRIPETOMATO != 0) {

            ArrayList<int[]> beRipe = new ArrayList<>();
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) {
                    // 토마토가 익은 것만 체크
                    if (MAP[i][j] == 1 && !VISITED[i][j]) {
                        bfs(i, j, beRipe);
                    }
                }
            }
            for (int[] ripedP : beRipe) {
                int ripeY = ripedP[0];
                int ripeX = ripedP[1];

                MAP[ripeY][ripeX] = 1;
            }

            if (RESULT > COLUMN * ROW) {
//                System.out.println("다 익을 수 없음");
                RESULT = -1;
                break;
            }
            RESULT += 1;
        }
        System.out.println(RESULT);
    }

    static void bfs(int y, int x, List<int[]> history) {
        VISITED[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < ROW && nx < COLUMN) {
                if (MAP[ny][nx] == 0 && !VISITED[ny][nx] && !RIPED[ny][nx]) {
                    RIPED[ny][nx] = true;
                    UNRIPETOMATO -= 1;
                    RIPETOMATO += 1;
                    history.add(new int[]{ny,nx});
                }
            }
        }
    }

}
