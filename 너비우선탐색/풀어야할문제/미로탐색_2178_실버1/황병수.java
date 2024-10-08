package 너비우선탐색.풀어야할문제.미로탐색_2178_실버1;

import 깊이우선탐색.풀어야할문제.헌내기는친구가필요해_21736_실버2.이태균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 황병수 {

    static int COL, ROW;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[] dx =  {-1, 0, 1, 0};
    static int[] dy =  {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        MAP = new int[ROW][COL];
        VISITED = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < COL; j++) {
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int y, int x) {
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{y, x,1});

        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            int current_y = now[0];
            int current_x = now[1];
            int distance = now[2];

            if (current_x == COL - 1 && current_y == ROW - 1) {
                return distance;
            }

            // 현재 위치에서 4방향으로 이동 가능여부 확인
            for (int i = 0; i < 4; i++) {
                int next_x = current_x + dx[i];
                int next_y = current_y + dy[i];

                // 범위 확인
                if (next_x >= 0 && next_x < COL && next_y >= 0 && next_y < ROW) {
                    if (MAP[next_y][next_x] == 1 && !VISITED[next_y][next_x]) {
                        // 방문 가능하면 큐에 추가
                        Q.add(new int[]{next_y, next_x, distance+1});
                        // 방문 처리
                        VISITED[next_y][next_x] = true;

                    }
                }
            }
        }
        return -1;
    }
}
