package class3.풀어야할문제.미로탐색_2178_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 황병수 {

    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(split[j-1]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,1,1});

        int[] dx = {1, -1, 0, 0};  // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int col = poll[0];
            int row = poll[1];
            int depth = poll[2];

            if (col == N && row == M) {
                return depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextCol = col + dy[i];
                int nextRow = row + dx[i];

                if (nextCol > 0 && nextRow > 0 && nextCol <= N && nextRow <= M && map[nextCol][nextRow] == 1) {
                    queue.add(new int[]{nextCol, nextRow, depth + 1});
                    map[nextCol][nextRow] = 0;  // 방문 표시
                }
            }
        }

        return -1;
    }
}
