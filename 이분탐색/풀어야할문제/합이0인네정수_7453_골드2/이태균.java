package 이분탐색.풀어야할문제.합이0인네정수_7453_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] A_LIST;
    public static int[] B_LIST;
    public static int[] C_LIST;
    public static int[] D_LIST;

    public static List<Integer> AB_PLUS_LIST = new ArrayList<>();
    public static List<Integer> AB_MINUS_LIST = new ArrayList<>();
    public static List<Integer> CD_PLUS_LIST = new ArrayList<>();
    public static List<Integer> CD_MINUS_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A_LIST = new int[N];
        B_LIST = new int[N];
        C_LIST = new int[N];
        D_LIST = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A_LIST[i] = Integer.parseInt(st.nextToken());
            B_LIST[i] = Integer.parseInt(st.nextToken());
            C_LIST[i] = Integer.parseInt(st.nextToken());
            D_LIST[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = A_LIST[i] + B_LIST[j];
                if (sum >= 0) {
                    AB_PLUS_LIST.add(sum);
                } else {
                    AB_MINUS_LIST.add(sum);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = C_LIST[i] + D_LIST[j];
                if (sum >= 0) {
                    CD_PLUS_LIST.add(sum);
                } else {
                    CD_MINUS_LIST.add(sum);
                }
            }
        }

        Collections.sort(CD_PLUS_LIST);
        Collections.sort(CD_MINUS_LIST);

        long answer = 0;

        for (int ab : AB_PLUS_LIST) {
            int target = -ab;
            if (Collections.binarySearch(CD_MINUS_LIST, target) >= 0) {
                int upper = upperBound(CD_MINUS_LIST, target);
                int lower = lowerBound(CD_MINUS_LIST, target);
                answer += (upper - lower);
            }
        }

        for (int ab : AB_MINUS_LIST) {
            int target = -ab;
            if (Collections.binarySearch(CD_PLUS_LIST, target) >= 0) {
                int upper = upperBound(CD_PLUS_LIST, target);
                int lower = lowerBound(CD_PLUS_LIST, target);
                answer += (upper - lower);
            }
        }

        int abZeroCount = upperBound(AB_PLUS_LIST, 0) - lowerBound(AB_PLUS_LIST, 0);
        int cdZeroCount = upperBound(CD_PLUS_LIST, 0) - lowerBound(CD_PLUS_LIST, 0);
        answer += (long) abZeroCount * cdZeroCount;

        System.out.println(answer);
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}