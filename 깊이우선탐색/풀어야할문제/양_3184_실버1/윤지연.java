package 깊이우선탐색.풀어야할문제.양_3184_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 윤지연 {
    /**
     * @param R 마당의 행, 3<=R
     * @param C 마당의 열, C <= 250
     * @param 마당 구조, R * C 크기
     * @return 양의 수, 늑대의 수(아침까지 살아있는)
     * @see '.' - 빈 필드, '#' - 울타리, 'o' - 양, 'v' - 늑대
     *
     */

    /* 수도코드
    1. 입력 처리:
        1. R과 C 입력받기
        2. 마당의 구조를 입력받아 저장
        3. 마당 크기만큼 방문 배열 초기화
    2. 마당 탐색
        1. 울타리를 만나면:
            1. 방문처리 하고 다음 탐색 노드로 이동한다.
        2. 울타리가 아니면:
            1. 해당 영역을 모두 탐색한다.
    		2. 모든 노드는 방문 표시
    		3. 울타리를 만나면 이전으로 돌아간다.
    		4. 양을 만나면 양의 수 증가
    		5. 늑대를 만나면 늑대의 수 증가
    	2. 해당 영역 탐색이 끝나면:
    		1. 양의 수가 늑대의 수보다 많다면 양의 수만 합산
    		2. 늑대의 수가 양보다 같거나 많으면 늑대의 수 합산
    4. 마당을 계속 순회한다.
    5. 아침까지 살아남은 양과 늑대의 수를 출력한다.
    */

    static int R;
    static int C;
    static char[][] yard;
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static boolean[][] visited;
    static int totalSheep = 0;
    static int totalWolf = 0;

    public static void main(String[] args) throws IOException {

    // 1. 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        yard = new char[R][C];
        visited = new boolean[R][C];

        // 마당 구조
        for (int i = 0; i < R; i++) {
            yard[i] = br.readLine().toCharArray();
        }

    // 2. 마당 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
               if (yard[i][j] == '#' || visited[i][j]) {
                   continue;
               } else if (yard[i][j] == 'v' || yard[i][j] == 'o') {
                   dfs(yard, j, i);
               }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    // 2. 영역 탐색
    static void dfs(char[][] yard, int x, int y) {
        int sheep = 0;
        int wolf = 0;

        // 시작 지점의 양, 늑대 카운트
        if (yard[y][x] == 'o') sheep = 1;
        if (yard[y][x] == 'v') wolf = 1;

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{y, x});

        // 시작 지점 방문 처리
        visited[y][x] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();

            // 상, 하, 좌, 우 이동하며 인접 영역 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = cur[1] + dx[i];
                int nextY = cur[0] + dy[i];

                // 마당을 벗어나거나 방문한 곳 또는 울타리는 건너뛰기
                if (nextX < 0 || nextX >= C  || nextY < 0 || nextY >= R || visited[nextY][nextX] || yard[nextY][nextX] == '#') {
                    continue;
                }

                stack.push(new int[]{nextY, nextX});
                visited[nextY][nextX] = true;

                if (yard[nextY][nextX] == 'o') sheep++;
                if (yard[nextY][nextX] == 'v') wolf++;
            }
        }

        // 영역 내 양과 늑대 수 비교
        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}
