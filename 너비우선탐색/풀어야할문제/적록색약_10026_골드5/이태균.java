package 너비우선탐색.풀어야할문제.적록색약_10026_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 이태균 {

    public static int N;
    public static char[][] PICTURE;
    public static boolean[][] VISITED;
    public static boolean[][] BLIND_VISITED;

    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그림의 크기 선언
        N = Integer.parseInt(br.readLine());

        // 그림 초기화 및 선언
        PICTURE = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                PICTURE[i][j] = line.charAt(j);
            }
        }

        // 방문 여부 배열 초기화
        VISITED = new boolean[N][N];
        BLIND_VISITED = new boolean[N][N];

        int count = 0;
        int blindCount = 0;

        // 일반적인 경우의 영역 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j]) {
                    // 일반인의 시각으로 BFS
                    bfs(i, j, false);
                    count++;
                }
                if (!BLIND_VISITED[i][j]) {
                    // 적록색약 시각으로 BFS
                    bfs(i, j, true);
                    blindCount++;
                }
            }
        }

        // 결과 출력
        System.out.println(count + " " + blindCount);
    }

    // BFS 구현
    private static void bfs(int y, int x, boolean isBlind) {
        Queue<int[]> q = new ArrayDeque<>();
        // 큐 시작점 저장
        q.add(new int[]{y, x});

        if (isBlind) {
            BLIND_VISITED[y][x] = true;
        } else {
            VISITED[y][x] = true;
        }

        while (!q.isEmpty()) {
            // 현재 위치 큐에서 꺼냄
            int[] now = q.poll();
            int currentY = now[0];
            int currentX = now[1];

            // 상하좌우로 이동할 수 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                // 범위를 벗어나지 않는지 확인
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    // 적록색약 시각으로 BFS 수행
                    if (isBlind && !BLIND_VISITED[nextY][nextX]) {
                        if ((PICTURE[y][x] == 'R' || PICTURE[y][x] == 'G') && (PICTURE[nextY][nextX] == 'R' || PICTURE[nextY][nextX] == 'G')) {
                            BLIND_VISITED[nextY][nextX] = true;
                            q.add(new int[]{nextY, nextX});
                        } else if (PICTURE[y][x] == PICTURE[nextY][nextX]) {
                            BLIND_VISITED[nextY][nextX] = true;
                            q.add(new int[]{nextY, nextX});
                        }
                    }

                    // 일반 시각으로 BFS 수행
                    if (!isBlind && !VISITED[nextY][nextX]) {
                        if (PICTURE[y][x] == PICTURE[nextY][nextX]) {
                            VISITED[nextY][nextX] = true;
                            q.add(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }
    }
}
