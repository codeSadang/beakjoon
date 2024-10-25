package 깊이우선탐색.풀어야할문제.양_3184_실버1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 홍창모 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int R, C, sheep, wolf, tmpSheep, tmpWolf;

    static String[][] board;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];
        visited = new boolean[R][C];

        for( int i = 0; i < R; i ++ ) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmpSheep = tmpWolf = 0;
                if (!visited[i][j] && (board[i][j].equals("o") || board[i][j].equals("v"))) {
                    dfs(i,j);

                    if (tmpSheep > tmpWolf) {
                        sheep += tmpSheep;
                    } else {
                        wolf += tmpWolf;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        if( board[x][y].equals("o") ) tmpSheep++;
        if ( board[x][y].equals("v") ) tmpWolf++;

        for( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && !board[nx][ny].equals("#") ) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }


    }

}
