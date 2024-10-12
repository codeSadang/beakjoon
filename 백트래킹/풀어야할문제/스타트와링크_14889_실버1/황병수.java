package 백트래킹.풀어야할문제.스타트와링크_14889_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {

    static int[][] memberScore;
    static boolean[] visited;
    static int N;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        memberScore = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                memberScore[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs( 0, 0);

        System.out.println(minValue);
    }

    static void dfs(int depth, int start) {

        if (depth == N/2) {
            List<Integer> ATeam = new ArrayList<>();
            List<Integer> BTeam = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    ATeam.add(i);
                } else {
                    BTeam.add(i);
                }
            }

            compareScore(ATeam, BTeam);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(depth + 1, i + 1);

                visited[i] = false;
            }
        }
    }

    static void compareScore(List<Integer> ATeam, List<Integer> BTeam ) {

//        System.out.println("ATeam = " + ATeam);
//        System.out.println("BTeam = " + BTeam);

        int ATeamScore = 0;
        int BTeamScore = 0;

        for (int i = 0; i < ATeam.size(); i++) {
            for (int j = i+1; j < ATeam.size(); j++) {
                ATeamScore += memberScore[ATeam.get(i)][ATeam.get(j)];
                ATeamScore += memberScore[ATeam.get(j)][ATeam.get(i)];
            }
        }

        for (int i = 0; i < BTeam.size(); i++) {
            for (int j = i+1; j < BTeam.size(); j++) {
                BTeamScore += memberScore[BTeam.get(i)][BTeam.get(j)];
                BTeamScore += memberScore[BTeam.get(j)][BTeam.get(i)];
            }
        }

//        System.out.println("ATeamScore = " + ATeamScore);
//        System.out.println("BTeamScore = " + BTeamScore);

        minValue = Math.min(Math.abs(ATeamScore -BTeamScore), minValue);
    }
}
