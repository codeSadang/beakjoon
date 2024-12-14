package 이분탐색.풀어야할문제.합이0인네정수_7453_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정수로 이루어진 크기가 같은 배열 A,B,C,D
 * 각 배열에 들어있는 정수 최대값은 2^28승
 */
public class 황병수 {
    static long length;
    static long[][] AList;

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Long.parseLong(br.readLine());

        long[] A = new long[(int) length];
        long[] B = new long[(int) length];
        long[] C = new long[(int) length];
        long[] D = new long[(int) length];

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        // 두 배열의 합 생성
        long[] resultA = new long[(int) (length * length)];
        long[] resultB = new long[(int) (length * length)];
        int idx = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                resultA[idx] = A[i] + B[j];
                resultB[idx] = C[i] + D[j];
                idx++;
            }
        }


        Arrays.sort(resultA);
        Arrays.sort(resultB);

        System.out.println(Arrays.toString(resultA));
        System.out.println(Arrays.toString(resultB));


        int left = 0;
        int right = resultB.length - 1;
        long count = 0;


        // 투 포인터와 이진 탐색 결합
        while (left < resultA.length && right >= 0) {
            long sum = resultA[left] + resultB[right];

            if (sum == 0) {
                long aCount = 1;
                long bCount = 1;

                // resultA에서 중복된 값 세기
                while (left + 1 < resultA.length && resultA[left] == resultA[left + 1]) {
                    left++;
                    aCount++;
                }

                // resultB에서 중복된 값 세기
                while (right - 1 >= 0 && resultB[right] == resultB[right - 1]) {
                    right--;
                    bCount++;
                }

                // 카운트를 곱해서 결과 추가
                count += aCount * bCount;
                left++;
                right--;

            } else if (sum < 0) {
                left++; // 합이 0보다 작으면 resultA의 값을 증가
            } else {
                right--; // 합이 0보다 크면 resultB의 값을 감소
            }
        }

        System.out.println(count);
    }
}
