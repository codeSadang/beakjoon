package 다이나믹프로그래밍.풀어야할문제.구간합구하기5_11660_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        int[][] target = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 알고리즘(?!) 공부 필요... 흠...
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                target[i][j] = target[i - 1][j] + target[i][j - 1] - target[i - 1][j - 1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = target[x2][y2] - target[x1 - 1][y2] - target[x2][y1 - 1] + target[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
