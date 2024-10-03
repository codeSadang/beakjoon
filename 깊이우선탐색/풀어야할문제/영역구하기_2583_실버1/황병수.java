package 깊이우선탐색.풀어야할문제.영역구하기_2583_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 황병수 {

    static boolean[][] visited;
    static int[][] map;
    static List<Integer> result = new ArrayList<>();
    static int height;
    static int width;
    static int QCnt;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 값으로 초기화
        StringTokenizer st = new StringTokenizer(bf.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        QCnt = Integer.parseInt(st.nextToken());

        // 기본값이 0이나 false로 초기화 됨
        map = new int[height][width];
        visited = new boolean[height][width];


        // 영역 값 할당하기
        for (int i = 0; i < QCnt; i++) {
            st = new StringTokenizer(bf.readLine());
            int LBX = Integer.parseInt(st.nextToken());
            int LBY = Integer.parseInt(st.nextToken());

            int RTX = Integer.parseInt(st.nextToken());
            int RTY = Integer.parseInt(st.nextToken());

            for (int j = LBX; j < RTX; j++) {
                for (int k = LBY; k < RTY; k++) {
                    map[k][j] = 1;
                }
            }
        }

        // 조회하기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    stackDfs(j,i);
                }
            }
        }

        System.out.println(result.size());
        System.out.println(result.stream()
                .sorted() // 정렬
                .map(String::valueOf) // 문자열로 변환
                .collect(Collectors.joining(" "))); // 공백으로 구분하여 하나의 문자열로
    }


    static void stackDfs(int initX, int initY) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{initX,initY});
        int count = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currX = current[0];
            int currY = current[1];

            if (visited[currY][currX]) continue; // 이미 방문한 경우 무시
            visited[currY][currX] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nowX = currX + dx[i];
                int nowY = currY + dy[i];

                if(nowX >= 0 && nowX < width && nowY >= 0 && nowY < height && !visited[nowY][nowX] && map[nowY][nowX] == 0) {
                    stack.push(new int[]{nowX, nowY});

                }
            }
        }
        result.add(count);
    }
}
