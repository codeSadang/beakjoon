package 다이나믹프로그래밍.시험볼문제.구간합구하기5_11660_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int[][] bp;
    static int[][] bpSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int InputValue = Integer.parseInt(st.nextToken());
        int TestCase = Integer.parseInt(st.nextToken());

        bp = new int[InputValue+1][InputValue+1];
        bpSum = new int[InputValue+1][InputValue+1];

        for (int y = 1; y <= InputValue; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= InputValue; x++) {
                bp[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 값 할당
        for (int y = 1; y <= InputValue; y++) {
            for (int x = 1; x <= InputValue; x++) {
                bpSum[y][x] = bpSum[y-1][x] + bpSum[y][x-1] - bpSum[y-1][x-1] + bp[y][x];
            }
        }

        // 계산
        for (int i = 0; i < TestCase; i++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int result = bpSum[endX][endY] - bpSum[endX][startY-1] - bpSum[startX-1][endY] + bpSum[startX-1][startY-1];
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
