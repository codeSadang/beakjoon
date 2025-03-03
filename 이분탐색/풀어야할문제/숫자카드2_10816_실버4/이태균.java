package 이분탐색.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] N_CARD_LIST;
    public static int M;
    public static int[] M_CARD_LIST;
    public static int[] RESULT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_CARD_LIST = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_CARD_LIST[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N_CARD_LIST);

        M = Integer.parseInt(br.readLine());
        M_CARD_LIST = new int[M];
        RESULT = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            M_CARD_LIST[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            RESULT[i] = binary_search(M_CARD_LIST[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int res : RESULT) {
            sb.append(res).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static int binary_search(int target) {
        int left = lowerBound(target);
        int right = upperBound(target);

        if (left == -1 || right == -1) {
            return 0;
        }

        return right - left;
    }

    private static int lowerBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (N_CARD_LIST[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left < N && N_CARD_LIST[left] == target) {
            return left;
        }

        return -1;
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (N_CARD_LIST[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left > 0 && N_CARD_LIST[left - 1] == target) {
            return left;
        }

        return -1;
    }
}