package 이분탐색.풀어야할문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] N_ARR;
    public static int M;
    public static int[] M_ARR;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_ARR = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_ARR[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        M_ARR = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            M_ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N_ARR);

        for (int i = 0; i < M; i++) {
            if (binary_search(M_ARR[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean binary_search(int target) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (N_ARR[mid] == target) {
                return true;
            } else if (N_ARR[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}