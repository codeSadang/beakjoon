package class4.풀어야할문제.N과M5_15654_실버3;

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

        backtracking(ARR[0]);
    }

    private static void backtracking(int start) {
        if (NUM_LIST.size() == M) {
            for (Integer num : NUM_LIST) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!NUM_LIST.contains(ARR[i])) {
                NUM_LIST.add(ARR[i]);
                backtracking(i + 1);
                NUM_LIST.remove(NUM_LIST.size() - 1);
            }
        }
    }

}