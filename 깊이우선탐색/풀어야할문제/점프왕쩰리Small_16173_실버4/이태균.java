package 깊이우선탐색.풀어야할문제.점프왕쩰리Small_16173_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[][] MAP;
    public static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        VISITED = new boolean[N][N];

        if (dfs()) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static boolean dfs() {
        Stack<Node> stack = new Stack<>();

        stack.push(new Node(0, 0));
        VISITED[0][0] = true;

        while (!stack.isEmpty()) {
            Node now = stack.pop();
            int now_row = now.row;
            int now_col = now.col;

            // 도착 지점(-1)에 도착하면 성공
            if (MAP[now_row][now_col] == -1) {
                return true;
            }

            int jump = MAP[now_row][now_col];

            // 오른쪽으로 이동
            int next_col = now_col + jump;
            if (next_col < N && !VISITED[now_row][next_col]) {
                stack.push(new Node(now_row, next_col));
                VISITED[now_row][next_col] = true;
            }

            // 아래쪽으로 이동
            int next_row = now_row + jump;
            if (next_row < N && !VISITED[next_row][now_col]) {
                stack.push(new Node(next_row, now_col));
                VISITED[next_row][now_col] = true;
            }
        }

        return false;
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
