package 깊이우선탐색.풀어야할문제.양_3184_실버1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**

 * 입력값
 * R = 행
 * C = 열
 *
 * 1. 전역변수 선언 ( R, C, sheep, wolf, dx, dy, visited, map)
 * 2. 모든 위치에서 이중 for문을 통해서 시작
 * 3. 이중 for문 안에서 visited를 체크하고 , && 울타리 ㅇ닐떄 방문하지 않았을 시에 dfs 시작
 * 4. dfs 에서 stack 방식을 사용 (int y, int x)
 * 4-1. 초기설정 (tempSheep, tempWolf)
 * 5. stack 에 값을 넣고, 값이 없을 떄까지 while 문
 * 6. while 문 안에서 값을 꺼내고 해당 값에 따라 종료 조건 설정
 * 6-1. 종료 조건은 해당 o가 아닐 경우
 * 6-2. o 인 경우 tempSheep 추가, v인 경우 tempWolf + 1;
 * 7. while 문 안에서 방향에 따라 다른 좌표를 지정
 * 8. visited 체크하고, stack 에 추가
 *
 * 10. while 문에서 빠져나오면 sheep 과 wolf 체크해서 sheep > wolf 이면, 더한값을 sheep 에
 * 그렇지 않으면 더한값을 wolf에 추가
 */
public class 황병수 {

    static String[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int wolf = 0;
    static int sheep = 0;
    static int R,C;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().split("");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && !field[i][j].equals("#"))  {
                    dfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void dfs(int y, int x) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{y,x});
        visited[y][x] = true;

        int tempWolf = 0;
        int tempSheep = 0;
        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            int nowY = now[0];
            int nowX = now[1];

            if (field[nowY][nowX].equals("v")) tempWolf ++;
            if (field[nowY][nowX].equals("o")) tempSheep ++;

            for (int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
                    if(!visited[ny][nx] && !field[ny][nx].equals("#")) {
                        visited[ny][nx] = true;
                        stack.push(new int[]{ny,nx});
                    }
                }
            }

        }
        if (tempSheep > tempWolf) {
            sheep += tempSheep;
        } else {
            wolf += tempWolf;
        }
    }
}
