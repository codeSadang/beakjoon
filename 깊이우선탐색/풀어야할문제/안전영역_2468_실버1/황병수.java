package 깊이우선탐색.풀어야할문제.안전영역_2468_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 황병수 {

    static int size;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;
    static int maxSize = 0; // 모두 잠기는 최대 홍수 크기


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 영역 크기
        size = Integer.parseInt(bf.readLine());

        // 초기화
        visited = new boolean[size][size];
        map = new int[size][size];

        // 값 할당
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxSize = Math.max(maxSize, map[i][j]);
            }
        }

        // 탐색
        for (int k = 0; k < maxSize; k++) {
            visited = new boolean[size][size]; // 방문 배열 초기화
            int count = 0; // 현재 높이에서 안전한 영역의 수

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    if (map[i][j] > k && !visited[i][j]) { // 현재 높이보다 높으면
                        /**
                         * 재귀 방식
                         */
//                        dfs(i, j, k);
//                        count++; // 새로운 안전 지역 발견


                        /**
                         * stack 방식
                         */
                        stackDfs(i, j, k);
                        count++; // 새로운 안전 지역 발견
                    }
                }
            }
            result = Math.max(result, count); // 최대 안전 지역 수 업데이트
        }
        System.out.println("result = " + result);
    }


    static void dfs(int currX , int currY, int depth) {
        visited[currX][currY] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = currX + dx[i];
            int nowY = currY + dy[i];

            if(nowX >= 0 && nowX < size && nowY >= 0 && nowY < size && !visited[nowX][nowY] && map[nowX][nowY] > depth) {
                dfs(nowX, nowY, depth);
            }
        }
    }

    static void stackDfs(int initX , int initY, int depth) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{initX, initY});

        while (!stack.empty()) {
            int[] current = stack.pop();
            int currX = current[0];
            int currY = current[1];

            visited[currX][currY] = true;

            for (int i = 0; i < 4; i++) {
                int nowX = currX + dx[i];
                int nowY = currY + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < size && nowY < size && !visited[nowX][nowY] && map[nowX][nowY] > depth) {
                    stack.push(new int[]{nowX, nowY});
                }
            }
        }
    }
}
