package 백트래킹.풀어야할문제.넴모넴모_14712_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비어있는 칸을 임의로 골라 넴모를 올려놓거나
 * 넴모가 올라간 칸 4개가 2x2 사각형을 이루는 부분을 찾아 그 위에 있는 넴모들을 모두 없애는 것을 반복
 *
 * 2x2가 생기지 않게 하기
 */
public class 황병수 {

    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        backtracking(0,0);

        System.out.println(count);
    }

    private static void backtracking(int y, int x) {

        if (y == N ) {
            count++;
            return;
        }

        // 다음 위치로 넘어갈 y, x 좌표
        int nextY = (x == M - 1) ? y + 1 : y;
        int nextX = (x == M - 1) ? 0 : x + 1;

        // 현재 위치에 넴모를 놓을 수 있는지 확인
        if (canPlaceNemmo(y, x)) {
            visited[y][x] = true;
            backtracking(nextY, nextX);
            visited[y][x] = false;
        }

        // 현재 위치에 넴모를 놓지 않고 다음 위치로 이동
        backtracking(nextY, nextX);
    }

    private static boolean canPlaceNemmo(int y, int x) {

        // 현재 위치가 격자 내에서 2x2를 이루는지 확인
        if (y > 0 && x > 0) {
            // 좌상단, 위쪽, 왼쪽이 모두 1인 경우 2x2가 형성됨
            if (visited[y-1][x] && visited[y][x-1] && visited[y-1][x-1]) {
                return false; // 2x2가 형성되므로 넴모를 놓을 수 없음
            }
        }
        return true; // 2x2가 형성되지 않음, 넴모를 놓을 수 있음
    }
}
