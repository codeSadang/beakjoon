package 너비우선탐색.풀어야할문제.적록색약_10026_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class 황병수 {


    static String[][] map;
    static boolean[][] visited;
    static boolean[][] visitedA;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static HashMap<String, Integer> hashMapA = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        visitedA = new boolean[N][N];
        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = split[j];
            }
        }

        int Cnt = 0;
        int CntA = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    String color = map[i][j];

                    bfs(i,j, color);
                    hashMap.put(color, hashMap.getOrDefault(color, 0) +1);
                    Cnt += 1;
                }

                if (!visitedA[i][j]) {
                    String color = map[i][j];
                    if ("R".equals(color) || "G".equals(color)) {
                        color = "R";
                    }

                    bfsA(i,j, color);
                    hashMapA.put(color, hashMapA.getOrDefault(color, 0) +1);
                    CntA += 1;
                }
            }
        }

        System.out.println(Cnt + " " + CntA);

    }


    static void bfs(int y, int x, String color) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currY = curr[0];
            int currX = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                    if (!visited[ny][nx] && map[ny][nx].equals(color)) {
                        queue.add(new int[]{ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    static void bfsA(int y, int x, String color) { // R
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visitedA[y][x] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currY = curr[0];
            int currX = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {

                    String nowColor;
                    if (map[ny][nx].equals("G") || map[ny][nx].equals("R")) {
                        nowColor = "R";
                    } else {
                        nowColor = "B";
                    }

                    if (!visitedA[ny][nx] && nowColor.equals(color)) {
                        queue.add(new int[]{ny, nx});
                        visitedA[ny][nx] = true;
                    }

                }
            }
        }
    }
}
