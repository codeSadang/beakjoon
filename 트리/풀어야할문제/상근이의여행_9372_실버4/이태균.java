package 트리.풀어야할문제.상근이의여행_9372_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] airplane_list = new int[M][2];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                airplane_list[j][0] = Integer.parseInt(st.nextToken());
                airplane_list[j][1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(Arrays.deepToString(airplane_list));
        }
    }

    private static void dfs() {
    }
}
