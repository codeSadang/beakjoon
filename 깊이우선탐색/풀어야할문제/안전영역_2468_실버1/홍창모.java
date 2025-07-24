package 깊이우선탐색.풀어야할문제.안전영역_2468_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 홍창모 {

    static int MAX = Integer.MIN_VALUE, MAX_AREA = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        MAP = new int[N][N];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < N; j++ ) {
                int height = Integer.parseInt(st.nextToken());
                // 최대높이
                MAX = Math.max( MAX, height );
                MAP[i][j] = height;
            }
        }

        for( int k = 0; k < MAX; k++) {
            // 처음 시작시 VISITED 초기화
            VISITED = new boolean[N][N];
            int cnt = 0;

            for( int i = 0; i < N; i++ ) {
                for( int j = 0; j < N; j++ ) {
                    if( MAP[i][j] > k && !VISITED[i][j] ) {
                        dfs(i, j, k);
                        cnt++;
                    }
                }
            }

            MAX_AREA = Math.max(MAX_AREA, cnt);
        }

        System.out.println(MAX_AREA);
    }

    private static void dfs(int row, int col, int height) {
        Stack<Node> st = new Stack<>();
        VISITED[row][col] = true;
        st.push(new Node(row, col, height));

        while (!st.isEmpty()) {
            Node curr = st.pop();

            int currRow = curr.row;
            int currCol = curr.col;
            int currHeight = curr.height;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N && !VISITED[nextRow][nextCol] ) {
                    if( MAP[nextRow][nextCol] > currHeight ) {
                        st.push(new Node(nextRow, nextCol, currHeight));
                        VISITED[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int row;
        int col;
        int height;

        public Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
