package 깊이우선탐색.풀어야할문제.단지번호붙이기_2667_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;

    static List<Integer> ANSWER;
    static int[][] MAP;
    static boolean[][] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        MAP = new int[N][N];
        VISITED = new boolean[N][N];
        ANSWER = new ArrayList<>();

        for( int i = 0; i < N; i++ ) {
            char[] charArray = br.readLine().toCharArray();
            for( int j = 0; j < N; j++ ) {
                MAP[i][j] = charArray[j] - '0';
            }
        }

        int complex = 0;

        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < N; j++ ) {
                if( MAP[i][j] == 1 && !VISITED[i][j] ) {
                    dfs(new Node(i, j));
                    complex++;
                }
            }
        }

        Collections.sort(ANSWER);

        StringBuilder sb = new StringBuilder();
        sb.append(complex).append("\n");

        for( int num : ANSWER ) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(Node node) {
        int totalCnt = 0;

        Stack<Node> st = new Stack<>();
        st.push(node);
        VISITED[node.row][node.col] = true;

        while (!st.isEmpty()) {
            Node curr = st.pop();

            int currRow = curr.row;
            int currCol = curr.col;
            totalCnt++;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && !VISITED[nextRow][nextCol] ) {
                    if( MAP[nextRow][nextCol] == 1 ) {
                        st.push(new Node(nextRow, nextCol));
                        VISITED[nextRow][nextCol] = true;
                    }
                }
            }
        }

        ANSWER.add(totalCnt);

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
