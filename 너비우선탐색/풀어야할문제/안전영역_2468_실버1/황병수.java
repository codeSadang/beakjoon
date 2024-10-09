package 너비우선탐색.풀어야할문제.안전영역_2468_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static boolean[][] visited;
    static int size;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];
        int maxHeight = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int nowCnt = Integer.parseInt(st.nextToken());
                map[i][j] = nowCnt;
                maxHeight = Math.max(nowCnt, maxHeight);
            }
        }
        for (int i = 1; i <= maxHeight; i++) {

            int count = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {

                    if(!visited[j][k] && map[j][k] > i) {
                        bfs(j, k, i);
                        count += 1;
                    }
                }
            }
            result.add(count);

            visited = new boolean[size][size];

        }

        for (Integer i : result) {
            System.out.println("i = " + i);
        }
        System.out.println(Collections.max(result));
    }

    static int bfs(int y, int x, int height) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{y,x});
        visited[y][x] = true;
        int maxCount = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currY = curr[0];
            int currX = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];

                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if(!visited[ny][nx] && map[ny][nx] > height) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }


        return maxCount;
    }
}
