package 완전탐색.풀어야할문제.스타트와링크_14889_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[][] TEAM;
    public static boolean[] VISIT;
    public static int MIN_DIFF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        TEAM = new int[N][N];
        VISIT = new boolean[N];

        // 능력치 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                TEAM[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 나누기 백트래킹 알고리즘
        backtracking(0, 0);

        System.out.println(MIN_DIFF);
    }

    private static void backtracking(int index, int count) {
        // 모든 사람을 탐색한 경우
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        // 백트래킹을 통해 팀 나누기
        for (int i = index; i < N; i++) {
            if (!VISIT[i]) {
                VISIT[i] = true;
                backtracking(i + 1, count + 1);
                VISIT[i] = false;
            }
        }
    }

    private static void calculateDifference() {
        int team_start = 0;
        int team_link = 0;

        // 팀 능력치 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (VISIT[i] && VISIT[j]) {
                    team_start += TEAM[i][j];
                } else if (!VISIT[i] && !VISIT[j]) {
                    team_link += TEAM[i][j];
                }
            }
        }

        // 최솟값 업데이트
        int diff = Math.abs(team_start - team_link);
        MIN_DIFF = Math.min(MIN_DIFF, diff);
    }

}