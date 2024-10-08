package 너비우선탐색.풀어야할문제.미로탐색_2178_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이태균 {

    public static int ROW;
    public static int COL;
    public static int[][] MAP;
    public static boolean[][] VISITED;

    // 상하좌우 이동을 위한 배열
    public static int[] DX = {0, 1, 0, -1};
    public static int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 미로 크기 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        // 미로 정보 초기화
        MAP = new int[ROW][COL];
        VISITED = new boolean[ROW][COL];

        // 미로 입력
        for (int i = 0; i < ROW; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < COL; j++) {
                MAP[i][j] = Integer.parseInt(str[j]);
            }
        }

        // BFS 탐색 시작 (시작 위치는 0, 0)
        System.out.println(bfs(0, 0));
    }

    // BFS 구현
    public static int bfs(int x, int y) {
        Queue<int[]> Q = new ArrayDeque<>();
        // 큐에 시작점과 거리(1)를 저장
        Q.add(new int[]{y, x, 1});
        // 시작점 방문 처리
        VISITED[y][x] = true;

        while (!Q.isEmpty()) {
            // 현재 위치를 큐에서 꺼냄
            int[] now = Q.poll();
            int current_y = now[0];
            int current_x = now[1];
            int distance = now[2];

            // 도착지점에 도달했으면 탐색 종료
            if (current_x == COL - 1 && current_y == ROW - 1) {
                return distance;
            }

            // 상하좌우로 이동할 수 있는지 확인
            for (int i = 0; i < 4; i++) {
                int next_x = current_x + DX[i];
                int next_y = current_y + DY[i];

                // 범위를 벗어나지 않는지 확인
                if (next_x >= 0 && next_x < COL && next_y >= 0 && next_y < ROW) {
                    // 이동할 수 있는 경로인지 (1인지 확인)
                    if (MAP[next_y][next_x] == 1 && !VISITED[next_y][next_x]) {
                        // 큐에 다음 위치와 거리를 저장
                        Q.add(new int[]{next_y, next_x, distance + 1});
                        // 방문 처리
                        VISITED[next_y][next_x] = true;
                    }
                }
            }
        }
        // 도착할 수 없는 경우 -1 반환
        return -1;
    }
}