package class4.풀어야할문제.파이프옮기기1_17070_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class 황병수 {
    static int[][] map;
    static boolean[][] visited;
    static int N,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking();
        System.out.println(R);
    }

    private static void backtracking() {
        ArrayDeque<Node> que = new ArrayDeque<>();

        que.add(new Node(1,2,0));

        while (!que.isEmpty()) {
            Node poll = que.poll();
            int y = poll.y;
            int x = poll.x;
            int state = poll.state;

            // 최종 포지션 도착하면 종료 조건
            if (y == N && x == N) {
                R++;
                continue;
            }

            // 파이프가 가로일 때
            if (state == 0) {
                // 가로 이동
                horizontal(y, x, que);
                // 대각선 이동
                diagonal(y, x, que);
            }

            // 파이프가 세로일 때
            else if (state == 1) {
                // 세로 이동
                vertical(y, x, que);
                // 대각선 이동
                diagonal(y, x, que);
            }

            // 파이프가 대각선일 때
            else if (state == 2) {
                // 세로 이동
                vertical(y, x, que);
                // 가로 이동
                horizontal(y, x, que);
                // 대각선 이동
                diagonal(y, x, que);
            }
        }
    }

    private static void horizontal(int y, int x, ArrayDeque<Node> que) {
        if (x < N && map[y][x +1] == 0 ) {
            que.add(new Node(y, x+1, 0));
        }
    }

    private static void vertical(int y, int x, ArrayDeque<Node> que) {
        if (y < N && map[y +1][x] == 0) {
            que.add(new Node(y+1, x, 1));
        }
    }

    private static void diagonal(int y, int x, ArrayDeque<Node> que) {
        if (y < N && x < N && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0 ) {
            que.add(new Node(y+1, x+1, 2));
        }
    }


    static class Node  {
        int y, x, state;
        Node(int y, int x, int state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }
    }
}
