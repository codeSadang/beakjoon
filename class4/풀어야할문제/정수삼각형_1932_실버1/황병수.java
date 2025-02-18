package class4.풀어야할문제.정수삼각형_1932_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int[][] map;
    static int[][] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        map = new int[M+1][M+2];
        result = new int[M+1][M+2];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        result[1][1] = map[1][1];

        // DP 계산
        for (int i = 2; i <= M; i++) {
            for (int j = 1; j <= i; j++) {
                result[i][j] = map[i][j] + Math.max(result[i - 1][j - 1], result[i - 1][j]);
            }
        }

        // 마지막 줄에서 최댓값 찾기
        int maxValue = 0;
        for (int j = 1; j <= M; j++) {
            maxValue = Math.max(maxValue, result[M][j]);
        }

        System.out.println(maxValue);
    }
}
