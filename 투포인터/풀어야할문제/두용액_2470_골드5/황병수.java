package 투포인터.풀어야할문제.두용액_2470_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.StringTokenizer;

/**
 * 산성용액과 알칼리성 용액 보유
 * 용액의 특성을 나타내는 하나의 정수가 주어짐;

 * 산성     1 ~  1,000,000,000 양의 정수
 * 알칼리성 -1 ~ -1,000,000,000 음의 정수

 * 같은 양의 두 용액을 혼합해서 특성값이 0에 가까운 용액을 만들려고 한다.
 * 참고, 두 종류의 알칼리성 용액 또는 두 종류의 산성용액으로만 만들어도 된다.
 * 즉, 2개의 서로 다른 용액을 혼합하기만 하면 된다.
 */
public class 황병수 {

    static int N;
    static int[] AList;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        AList = new int[N];
        result = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(AList);

        int left = 0;
        int right = N - 1;
        int closestSum  = Integer.MAX_VALUE;

        while (left < right) {

            int sum = AList[left] + AList[right];

            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                result[0] = AList[left];
                result[1] = AList[right];
            }

            if (sum == 0) break;
            else if (sum > 0) right--;
            else left++;
        }

        Arrays.sort(result);
        System.out.println(result[0] +  " " + result[1]);
    }
}
