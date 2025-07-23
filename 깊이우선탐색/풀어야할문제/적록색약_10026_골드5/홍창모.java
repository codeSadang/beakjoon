package 깊이우선탐색.풀어야할문제.적록색약_10026_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 홍창모 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;

    static char[][] MAP;
    static boolean[][] VISITED, WEAKNESS_VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        MAP = new char[N][N];
        VISITED = new boolean[N][N];
        WEAKNESS_VISITED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for( int j = 0; j < N; j++ ) {
                MAP[i][j] = charArray[j];
            }
        }

        int weaknessCnt = 0;
        int generalCnt = 0;

        for (int i = 0; i < N; i++) {
            for( int j = 0; j < N; j++ ) {
                if( !WEAKNESS_VISITED[i][j] ) {
                    colorWeakness(i, j, MAP[i][j]);
                    weaknessCnt++;
                }
                if( !VISITED[i][j] ) {
                    general(i, j, MAP[i][j]);
                    generalCnt++;
                }
            }
        }

        System.out.print(generalCnt + " " +weaknessCnt);

    }

    static void colorWeakness(int row, int col, char color) {
        // 적록색약이 있는 사람인 경우
        Stack<Node> st = new Stack<>();
        st.add(new Node(row, col, color));
        WEAKNESS_VISITED[row][col] = true;

        while (!st.isEmpty()) {
            Node curr = st.pop();

            int currRow = curr.row;
            int currCol = curr.col;
            char currColor = curr.color;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N && !WEAKNESS_VISITED[nextRow][nextCol]) {
                    if( currColor == 'R' || currColor == 'G' ) {
                        // 현재 색상이 R또는 G인 경우
                        if( MAP[nextRow][nextCol] == 'R' || MAP[nextRow][nextCol] == 'G' ) {
                            st.push(new Node(nextRow, nextCol, MAP[nextRow][nextCol] ));
                            WEAKNESS_VISITED[nextRow][nextCol] = true;
                        }
                    } else if( MAP[nextRow][nextCol] == currColor ) {
                        // 같은 색상인 경우에만 stack에 추가
                        st.push(new Node(nextRow, nextCol, currColor));
                        WEAKNESS_VISITED[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    static void general(int row, int col, char color) {
        Stack<Node> st = new Stack<>();
        st.add(new Node(row, col, color));
        VISITED[row][col] = true;

        while (!st.isEmpty()) {
            Node curr = st.pop();

            int currRow = curr.row;
            int currCol = curr.col;
            char currColor = curr.color;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N && !VISITED[nextRow][nextCol]) {
                    if( MAP[nextRow][nextCol] == currColor ) {
                        // 같은 색상인 경우에만 stack에 추가
                        st.push(new Node(nextRow, nextCol, currColor));
                        VISITED[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int row;
        int col;
        char color;

        public Node(int row, int col, char color) {
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }
}
