package 백트래킹.풀어야할문제.감시피하기_18428_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N*N 복도가 있다.
 *
 * 특정한 위치에는 선생님, 학생, 혹은 장애물이 위치
 * 학생들이 수업시간에 나왔는데 선생님 감시에 들키지 않는것이 목표
 * 각 성생님들은 자신의 우치에서 상 하 좌 우 4가지 방향으로 감시
 *
 * 복도에 장애물이 위치한 경우
 * 선생님은 장애물 뒤편에 숨어있는 학생은 볼 수 없다.
 * 선생님은 상하좌우 4가지 방향에 대하여 장애물이 막히기 전까지 학생들은 모두 볼수 있다.
 *
 * 선생님 : T
 * 학생 : S
 * 장애물 : O
 *
 * 장애물을 순서대로 3개 배열해보자.
 * 배열한 후 선생님들 좌표로 부터 각 방향으로 이동하고, 이때, 학생이 발견되면 뒤로가기
 *
 * 그 다음 장애물 다시 놓고
 */
public class 황병수 {

    static String[][] map;
    static int N;
    static List<int[]> teachers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = split[j];
                if (map[i][j].equals("T")) {
                    teachers.add(new int[]{i,j});
                }
            }

        }

        choiceBlock(0,0, new ArrayList<int[]>());

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void choiceBlock(int y, int x, List<int[]> selected) {

        if (y == N) return;

        if (selected.size() == 3) {
            if (monitoring(selected)) {
                result = true;  // 학생이 감시로부터 피할 수 있는 경우
            }
            return;
        }

        if (x == N) {
            choiceBlock(y + 1, 0, selected);
            return;
        }

        if (map[y][x].equals("X")) {
            selected.add(new int[]{y,x});
            choiceBlock(y, x + 1, selected);
            selected.remove(selected.size() - 1);
        }
        choiceBlock(y, x + 1, selected);
    }

    /**
     * 여기에서 선생님들 위치에서 4개 방향으로 이동하고 학생발견되면 종료!!
     *
     */
    private static boolean  monitoring(List<int[]> selected) {

        boolean stopFlag = false;
        String[][] tempMap = new String[N][N];
        for (int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone(); // 각 행을 복사
        }

        for (int[] ints : selected) {
            int y = ints[0];
            int x = ints[1];
            tempMap[y][x] = "O";
        }

        /**
         * 이거보면 이해하기 쉽습니다.
         */
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) System.out.print(tempMap[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println(" ==================== " );


        for (int[] teacher : teachers) {

            if (stopFlag) break;

            int y = teacher[0];
            int x = teacher[1];

            for (int i = 0; i < 4; i++) {
                int ny = y;
                int nx = x;
                while (true) {
                    ny += dy[i];
                    nx += dx[i];

                    // 범위 밖으로 나가면 중지
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        break;
                    }

                    // 장애물이 있으면 중지
                    if (tempMap[ny][nx].equals("O")) {
                        break;
                    }

                    // 학생(S)을 발견하면 실패
                    if (tempMap[ny][nx].equals("S")) {
                        return false;
                    }
                }
            }
        }
        // 학생이 감시되지 않은 경우
        return true;
    }
}
