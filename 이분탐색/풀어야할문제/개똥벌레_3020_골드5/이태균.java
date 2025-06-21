package 이분탐색.풀어야할문제.개똥벌레_3020_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int H;
    public static int[] 석순;
    public static int[] 종유석;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] 석순 = new int[N / 2];
        int[] 종유석 = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            석순[i] = Integer.parseInt(br.readLine());
            종유석[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(석순);
        Arrays.sort(종유석);

        binary_search();
    }

    private static void binary_search() {
        int min = N;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            lowerBound(석순, i);
            lowerBound(종유석, H - i + 1);

        }
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}