package 분할정복.풀어야할문제.치킨TOPN_11582_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 치킨집 맛의 수치를 오름순으로 정렬
 *
 */
public class 황병수 {

    static int N, K;
    static int[] ListA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ListA = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ListA[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        // 분할 정복 방식으로 맛 순위 계산
        tasteRank(ListA, N);
    }

    private static void tasteRank(int[] ListA, int size) {
        int subArraySize = 1; // 초기 부분 배열 크기

        while (subArraySize <= size) {
            for (int i = 0; i < size; i += subArraySize) {
                // 부분 배열 정렬
                Arrays.sort(ListA, i, Math.min(i + subArraySize, size));
            }

            // 부분 배열 크기를 기준으로 K단계를 확인
            if (subArraySize == size / K) {
                printArray(ListA);
                return;
            }

            subArraySize *= 2; // 부분 배열 크기 두 배로 증가
        }
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
