package 깊이우선탐색.풀어야할문제.단지번호붙이기_2667_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 황병수 {

    static int[][] map;
    static boolean[][] visited;
    static int size;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<Integer> result;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 사이즈
        size = Integer.parseInt(br.readLine());

        // 초기화
        map = new int[size][size];
        visited = new boolean[size][size];
        result = new ArrayList<>();

        // 값 입력
        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고 방문하지 않았다면

                    /**
                     * 재귀 방식
                     */
//                    count = 0;
//                    dfs(i, j); // DFS 호출 및 카운트
//                    result.add(count); // 결과 리스트에 추가

                    /**
                     * stack 방식
                     */
                    count = 0;
                    result.add(dfsStack(i,j));
                }
            }
        }
        result = result.stream()
                .sorted() // 내림차순 정렬
                .collect(Collectors.toList());

        result.add(0,result.size());

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 8; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X >= 0 && X < size && Y >= 0 && Y < size && !visited[X][Y] && map[X][Y] == 1) {
                dfs(X, Y);
            }
        }
    }

    static int dfsStack(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y] = true;


        while (!stack.empty()) {
            int[] current = stack.pop();
            int currX = current[0];
            int currY = current[1];
            count++;

            for (int i = 0; i < 8; i++) {
                int nowX = currX + dx[i];
                int nowY = currY + dy[i];

                if (nowX >= 0 && nowX < size && nowY >= 0 && nowY < size && map[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                    stack.push(new int[]{nowX, nowY});
                    visited[nowX][nowY] = true;
                }
            }
        }

        return count;
    }
}
