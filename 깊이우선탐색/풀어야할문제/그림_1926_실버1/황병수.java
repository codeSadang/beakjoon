package 깊이우선탐색.풀어야할문제.그림_1926_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {


    static int[][] matrix;
    static boolean[][] visited;
    static int column, row, count, maxSize;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 할당
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        // 초기화
        matrix = new int[row][column];
        visited = new boolean[row][column];
        count = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if(!visited[i][j] && matrix[i][j] == 1) {
                    int size = dfs(i, j); // 현재 DFS의 크기를 반환받습니다.
                    count++; // 그림의 개수 증가
                    maxSize = Math.max(maxSize, size); // 최대 크기 갱신
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    static int dfs(int y, int x) {

        visited[y][x] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && ny >= 0 && nx < column && ny < row) {
                if (!visited[ny][nx] && matrix[ny][nx] == 1) {
                    size += dfs(ny, nx);
                }
            }
        }
        return size; // 현재 그림의 크기를 반환
    }
}
