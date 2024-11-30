package 해시.풀어야할문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static Set<Integer> N_SET;
    public static int M;
    public static int[] M_ARR;

    public static int[] RESULT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_SET = new HashSet<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_SET.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        M_ARR = new int[M];
        RESULT = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            M_ARR[i] = Integer.parseInt(st.nextToken());

            if (N_SET.contains(M_ARR[i])) {
                RESULT[i] = 1;
            } else {
                RESULT[i] = 0;
            }
        }

        for (int i : RESULT) {
            System.out.println(i);
        }
    }

}