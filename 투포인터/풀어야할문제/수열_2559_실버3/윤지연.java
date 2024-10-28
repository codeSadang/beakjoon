package 투포인터.풀어야할문제.수열_2559_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    - 연속된 K일 동안의 온도 합 중 최대값을 구한다.
    1. 입력처리
        1. N, K, 온도 배열
        2. maxTemperature, windowSum
    2. 배열 탐색
        1. 0 ~ K - 1까지 온도 합을 구한다.(초기 비교값)
        2. 범위를 하나씩 증가시키며 앞서 구한 온도 합과 비교하여 큰 값을 maxTemperature 에 할당한다.
    3. 출력
     */

    static int N;
    static int K;
    static int[] arr;
    static Integer maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        maxSum = findMaxSum(arr);
        System.out.println(maxSum);
    }

    public static int findMaxSum(int[] arr) {
        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = K; i < N; i++) {
            windowSum += arr[i] - arr[i - K];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
