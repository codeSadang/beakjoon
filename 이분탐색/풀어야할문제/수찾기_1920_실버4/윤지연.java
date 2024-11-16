package 이분탐색.풀어야할문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static int[] comparison;
    static int[] control;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        comparison = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            comparison[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        control = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            control[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(comparison);

        for (int i = 0; i < M; i++) {
            binarySearch(control[i]);
        }
    }

    private static void binarySearch(int target) {
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target == comparison[mid]) {
                System.out.println(1);
                return;
            } else if (target < comparison[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(0);
    }
}
