package 백트래킹.풀어야할문제.N과M5_15654_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 자연수 M이 주어졌을 때,
 * 이래 조건을 만족하는 길이가 M인 수열을 모두하는 프로그램을 작성하시오
 *
 * N개의 자연수 중에서 M개를 고른 수열

 */
public class 황병수 {

    static int N,M;
    static int[] list;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        backtracking(0, 0, "");
    }

    private static void backtracking(int index, int count, String message) {

        if (count == M) {
            System.out.println(message);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newMessage = message + list[i] + " ";
                backtracking(index + 1, count + 1, newMessage);
                visited[i] = false;
            }
        }
    }
}
