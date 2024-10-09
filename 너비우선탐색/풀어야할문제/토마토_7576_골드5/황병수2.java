package 너비우선탐색.풀어야할문제.토마토_7576_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수2 {

    static int ROW, COLUMN;
    static int UNRIPETOMATO = 0;
    static int RESULT;
    static int[][] MAP;
    static boolean[][] VISITED;
    static boolean[][] RIPED;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new ArrayDeque<>();
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
                    queue.add(new int[]{i,j,0});
                }

                if (MAP[i][j] == 0) {
                    UNRIPETOMATO += 1;
                }
            }
        }

        RESULT = bfs();

        if (UNRIPETOMATO == 0) {
            System.out.println(RESULT);
        } else {
            System.out.println(-1);
        }

    }

    static int bfs() {

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int currY = curr[0];
                int currX = curr[1];
                int currDay = curr[2];

                for (int i = 0; i < 4; i++) {
                    int ny = currY + dy[i];
                    int nx = currX + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < ROW && nx < COLUMN) {
                        if (MAP[ny][nx] == 0 && !VISITED[ny][nx] && !RIPED[ny][nx]) {
                            RIPED[ny][nx] = true;
                            queue.add(new int[]{ny, nx, currDay + 1});
                            UNRIPETOMATO -= 1;
                        }
                    }
                }
            }
            days += 1;
        }

        return days - 1;
    }
}
