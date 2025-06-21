package 이분탐색.풀어야할문제.나무자르기_2805_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static Integer[] TREE_LIST;
    public static Long RESULT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        TREE_LIST = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            TREE_LIST[i] = Integer.parseInt(st.nextToken());
        }

        binary_search();
        System.out.println(RESULT);
    }

    private static void binary_search() {
        long left = 0;
        long right = TREE_LIST[N - 1];

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (TREE_LIST[i] >= mid) {
                    sum += (TREE_LIST[i] - mid);
                }
            }

            if (sum >= M) {
                RESULT = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

}