package 이분탐색.풀어야할문제.개똥벌레_3020_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개똥벌레
 *
 * 석순과 종유석가득찬 동굴에 들어감
 * 길이 N
 * 높이 H
 * N은 짝수? 첫 번째 장애물은 항상 석순
 * 그 다음에는 종유석, 석순이 번갈아가면서 등장
 *
 * 길이가 14미터 높이가 5미터
 *
 */
public class 황병수 {

    static int N,H;
    static int[] top,bottom;

    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        BinarySearchMethod(br);


    }

    private static void BinarySearchMethod(BufferedReader br) throws IOException {

        int[] top = new int[N / 2]; // 석순
        int[] bottom = new int[N / 2]; // 종유석

        // 입력 처리
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                top[i / 2] = height; // 석순
            } else {
                bottom[i / 2] = height; // 종유석
            }
        }

        Arrays.sort(top);
        Arrays.sort(bottom);

        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        // 각 높이에 대해 장애물 계산
        for (int h = 1; h <= H; h++) {
            // 석순: h 이하의 장애물 수
            int bottomCount = top.length - lowerBound(top, h);
            // 종유석: H - h + 1 이상의 장애물 수
            int topCount = bottom.length - lowerBound(bottom, H - h + 1);

            int totalObstacles = bottomCount + topCount;

            // 최소값과 카운트 계산
            if (totalObstacles < minObstacles) {
                minObstacles = totalObstacles;
                count = 1;
            } else if (totalObstacles == minObstacles) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(minObstacles + " " + count);
    }

    // lowerBound 구현
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
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
