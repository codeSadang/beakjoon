package 넓이우선탐색.풀어야할문제.미로탐색_2178_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 황병수 {

    static int COLUMN, ROW;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[] dx =  {-1, 0, 1, 0};
    static int[] dy =  {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COLUMN = Integer.parseInt(st.nextToken());
        MAP = new int[ROW][COLUMN];
        VISITED = new boolean[ROW][COLUMN];

        for (int i = 0; i < ROW; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < COLUMN; j++) {
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x, 1});
        VISITED[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currY = current[0];
            int currX = current[1];
            int distance = current[2];

            if (currY == ROW - 1 && currX == COLUMN - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];
                if (ny >= 0 && nx >= 0 && ny < ROW && nx < COLUMN) {
                    if (!VISITED[ny][nx] && MAP[ny][nx] == 1) {
                        queue.add(new int[]{ny, nx, distance + 1});
                        VISITED[ny][nx] = true;
                    }
                }
            }

        }
        return -1;  // 목적지에 도달할 수 없는 경우
    }
}
