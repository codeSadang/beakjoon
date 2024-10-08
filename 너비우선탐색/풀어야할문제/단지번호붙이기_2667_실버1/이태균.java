package 너비우선탐색.풀어야할문제.단지번호붙이기_2667_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 이태균 {

    public static int N;
    public static int[][] MAP;
    public static boolean[][] VISITED;

    // 상하좌우 이동을 위한 배열
    public static int[] DX = {0, 1, 0, -1};
    public static int[] DY = {1, 0, -1, 0};

    // 단지별 집 갯수를 담을 배열
    public static List<Integer> LOCAL = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 크기 입력
        N = Integer.parseInt(br.readLine());

        // 지도 초기화
        MAP = new int[N][N];
        VISITED = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 1 && !VISITED[i][j]) {
                    bfs(i, j);
                }
            }
        }

        for (int n : LOCAL) {
            System.out.println(n);
        }

        int size = LOCAL.size();
        System.out.println(size);
    }

    private static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        // 큐에 시작점을 저장
        q.add(new int[]{y, x});
        // 시작점 방문 처리
        VISITED[y][x] = true;

        // 집 카운팅
        int home_cnt = 1;

        while (!q.isEmpty()) {
            // 현재 위치를 큐에서 꺼냄
            int[] now = q.poll();
            int current_y = now[0];
            int current_x = now[1];

            // 상하좌우로 이동할 수 있는지 확인
            for (int i = 0; i < 4; i++) {
                int next_x = current_x + DX[i];
                int next_y = current_y + DY[i];

                // 범위를 벗어나지 않는지 확인
                if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < N) {
                    // 이동할 수 있는 경로인지 (1인지, 방문했는지) 확인
                    if (MAP[next_y][next_x] == 1 && !VISITED[next_y][next_x]) {
                        // 큐에 다음 위치와 거리를 저장
                        q.add(new int[]{next_y, next_x});
                        // 방문 처리
                        VISITED[next_y][next_x] = true;
                        // 단지 수 증가
                        home_cnt++;
                    }
                }
            }
        }

        System.out.println("home_cnt = " + home_cnt);
        LOCAL.add(home_cnt);
    }

}