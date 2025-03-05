package class4.풀어야할문제.N과M9_15663_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] ARR;
    public static List<Integer> NUM_LIST = new ArrayList<>();
    public static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ARR);
        VISITED = new boolean[N];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (Integer num : NUM_LIST) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (!VISITED[i] && prev != ARR[i]) {
                VISITED[i] = true;
                NUM_LIST.add(ARR[i]);
                prev = ARR[i];
                backtracking(depth + 1);
                VISITED[i] = false;
                NUM_LIST.remove(NUM_LIST.size() - 1);
            }
        }
    }

}