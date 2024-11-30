package 이분탐색.풀어야할문제.합이0인네정수_7453_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {

    static int N;
    static long[] AB, CD;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        AB = new long[N * N];
        CD = new long[N * N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int idx1 = 0, idx2 = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                AB[idx1++] = A[j] + B[k];
                CD[idx2++] = C[j] + D[k];
            }
        }

        Arrays.sort(CD);

        for (long ab: AB) {
            long target = -ab;
            int leftIdx = lowerBound(target);
            int rightIdx = upperBound(target);
            count += rightIdx - leftIdx;
       }
        System.out.println(count);
    }

    private static int lowerBound(long target) {
        int left = 0;
        int right = CD.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(long target) {
        int left = 0;
        int right = CD.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
