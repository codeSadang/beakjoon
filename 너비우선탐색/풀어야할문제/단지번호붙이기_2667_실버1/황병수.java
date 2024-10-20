package 너비우선탐색.풀어야할문제.단지번호붙이기_2667_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class 황병수 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        visited = new boolean[size][size];
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        ArrayList<Integer> houseCounts = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    int houseCount = bfs(i, j);
                    houseCounts.add(houseCount);
                }
            }
        }
        // 단지 내 집의 수 오름차순 정렬
        Collections.sort(houseCounts);

        // 총 단지 수 출력
        System.out.println(houseCounts.size());
        for (int count : houseCounts) {
            System.out.println(count);
        }
    }

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        int count = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int currY = current[0];
            int currX = current[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];

                if (ny >= 0 && nx >= 0 && ny < size && nx < size) {
                    if(!visited[ny][nx] && map[ny][nx] == 1) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;

                    }
                }
            }
        }
        return count;
    }
}
