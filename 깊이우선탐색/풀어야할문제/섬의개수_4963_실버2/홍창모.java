package 깊이우선탐색.풀어야할문제.섬의개수_4963_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 홍창모 {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] MAP;
    static boolean[][] VISITED;
    static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while( true ) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if( w == 0 && h == 0 ) {
                break;
            }

            // MAP, VISITED 초기화
            MAP = new int[h][w];
            VISITED = new boolean[h][w];

            for( int i = 0; i < h; i++ ) {
                st = new StringTokenizer(br.readLine());
                for( int j = 0; j < w; j++ ) {
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for( int i = 0; i < h; i++ ) {
                for( int j = 0; j < w; j++ ) {
                    if( MAP[i][j] == 1 && !VISITED[i][j] ) {
                        dfs(i, j, w, h);
                        cnt++;
                    }
                }
            }

            SB.append(cnt).append("\n");
        }

        System.out.println(SB);
    }

    private static void dfs(int row, int col, int w, int h) {
        Stack<Node> st = new Stack<>();
        st.push(new Node(row, col));
        VISITED[row][col] = true;

        while(!st.isEmpty()) {
            Node curr = st.pop();

            int currRow = curr.row;
            int currCol = curr.col;

            for( int i = 0; i < 8; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextCol >= 0 && nextRow < h && nextCol < w && !VISITED[nextRow][nextCol] ) {
                    if( MAP[nextRow][nextCol] == 1 ) {
                        st.push(new Node(nextRow, nextCol));
                        VISITED[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
