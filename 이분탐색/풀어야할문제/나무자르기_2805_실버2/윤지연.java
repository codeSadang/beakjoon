package 이분탐색.풀어야할문제.나무자르기_2805_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N, M;
    static int[] trees;
    static int maxTree = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxTree = Math.max(maxTree, trees[i]);
        }

        long max = binarySearch();

        System.out.println(max);
    }

    private static long binarySearch() {
        long s = 0;
        long e = maxTree;
        long result = 0;

        while (s <= e) {
            long mid = (s + e) / 2;
            long sum = 0;

            // 나무 길이 합
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= M) {
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }
}
