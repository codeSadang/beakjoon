package 이분탐색.풀어야할문제.부분수열의합2_1208_골드1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N개의 정수로 이루어진 수열이 있음
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 던한 값이
 * S가 되는 경우의 수를 구하시오
 */
public class 황병수 {

    static int N, S;
    static int[] ListA;

    static List<Long> leftSums = new ArrayList<>();
    static List<Long> rightSums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ListA = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ListA[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 나누기
        int mid = N / 2;
        generateSubSums(Arrays.copyOfRange(ListA, 0, mid), leftSums);
        generateSubSums(Arrays.copyOfRange(ListA, mid, N), rightSums);

        // 오른쪽 합 정렬
        Collections.sort(rightSums);

        // 왼쪽 합과 비교하며 경우의 수 찾기
        long count = 0;
        for (long leftSum : leftSums) {
            count += countMatches(rightSums, S - leftSum);
        }

        // 공집합 제외
        if (S == 0) count--;

        System.out.println(count);
    }

    // 부분합 생성
    private static void generateSubSums(int[] arr, List<Long> sums) {
        int n = arr.length;
        for (int i = 0; i < (1 << n); i++) { // 2^n 경우의 수
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // j번째 원소 포함
                    sum += arr[j];
                }
            }
            sums.add(sum);
        }
    }

    // 이분 탐색으로 원하는 값 개수 찾기
    private static long countMatches(List<Long> sortedList, long target) {
        return upperBound(sortedList, target) - lowerBound(sortedList, target);
    }

    private static int lowerBound(List<Long> list, long target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int upperBound(List<Long> list, long target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}