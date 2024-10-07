package 깊이우선탐색.풀어야할문제.헌내기는친구가필요해_21736_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static String[][] map;
    static int ROW, COLUMN;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int friend = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COLUMN = Integer.parseInt(st.nextToken());
        visited = new boolean[ROW][COLUMN];
        map = new String[ROW][COLUMN];
        int rowI = 0;
        int columnI = 0;

        for (int i = 0; i < ROW; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < COLUMN; j++) {
                if (split[j].equals("I")) {
                    rowI = i;
                    columnI = j;
                }
                map[i][j] = split[j];
            }
        }

        dfs(rowI, columnI);

        if (friend == 0) {
            System.out.println("TT");
        } else {
            System.out.println(friend);
        }

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        if (map[y][x].equals("P")) {
            friend++;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx >= 0 && ny >= 0 && nx < COLUMN && ny < ROW) {
                if (!visited[ny][nx] && !map[ny][nx].equals("X")) {
                    dfs(ny,nx);
                }
            }
        }
    }
}
