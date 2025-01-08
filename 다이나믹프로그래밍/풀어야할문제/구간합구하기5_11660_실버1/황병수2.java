package 다이나믹프로그래밍.풀어야할문제.구간합구하기5_11660_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수2 {

    static int[][] map;
    static int[][] sumMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        sumMap = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumMap[i][j] = map[i][j] + sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1];
            }
        }
        System.out.println();

        for (int i = 0; i<= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(sumMap[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int SY = Integer.parseInt(st.nextToken());
            int SX = Integer.parseInt(st.nextToken());
            int DY = Integer.parseInt(st.nextToken());
            int DX = Integer.parseInt(st.nextToken());

            int sum =  + sumMap[SY-1][SX-1] - sumMap[DY][SX-1] - sumMap[SY-1][DX] + sumMap[DY][DX];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
