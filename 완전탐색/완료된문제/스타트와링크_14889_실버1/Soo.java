package 완전탐색.완료된문제.스타트와링크_14889_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 완전탐색 문제
 * 백트래킹 사용
 */
public class Soo {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        Soo soo = new Soo();
        int solution = soo.solution();
        System.out.println("solution = " + solution);
    }

    private int solution() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        // 능력치 입력
        for (int i = 0; i < N; i++) {
            String[] input = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 팀 나누기 (백트래킹 시작)
        divideTeam(0, 0);
        return minDiff;
    }

    private void divideTeam(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        // 백트래킹을 통해 팀 나누기
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divideTeam(i + 1, count + 1);


                visited[i] = false;
            }
        }
    }

    private void calculateDifference() {
        int teamA = 0, teamB = 0;

        // 팀 능력치 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += S[i][j];
                } else if (!visited[i] && !visited[j]) {
                    teamB += S[i][j];
                }
            }
        }

        // 최솟값 업데이트
        int diff = Math.abs(teamA - teamB);
        minDiff = Math.min(minDiff, diff);
    }
}
